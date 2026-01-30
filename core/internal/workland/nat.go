package workland

import (
	"enreach-agent/internal/reverseproxy"
	"enreach-agent/util"
	"flag"
	"github.com/pion/stun/v2"
	"log"
	"net"
	"os"
	"strings"
	"time"

	"github.com/oneclickvirt/gostun/model"
	"github.com/oneclickvirt/gostun/stuncheck"
)

// tryRFCMethod attempts NAT detection using specified RFC method
func tryRFCMethod(addrStr string, rfcMethod string) (bool, error) {
	currentProtocol := "ipv4"
	if model.IPVersion == "ipv6" || (model.IPVersion == "both" && strings.Contains(addrStr, "[") && strings.Contains(addrStr, "]")) {
		currentProtocol = "ipv6"
	}
	var err1, err2 error
	switch rfcMethod {
	case "RFC5780":
		log.Printf("[%s] Trying RFC 5780 method with server %s", currentProtocol, addrStr)
		err1 = stuncheck.MappingTests(addrStr)
		if err1 != nil {
			log.Printf("err1:%+v", err1)
			model.NatMappingBehavior = "inconclusive"
			log.Printf("[%s] Trying RFC 5780 method with server %s", currentProtocol, addrStr)
		}
		err2 = stuncheck.FilteringTests(addrStr)
		if err2 != nil {
			log.Printf("err1:%+v", err2)

			model.NatFilteringBehavior = "inconclusive"
			log.Printf("[%s] RFC5780 NAT filtering behavior: inconclusive", currentProtocol)
		}
	case "RFC5389":
		log.Printf("[%s] Trying RFC 5389/8489 method with server %s", currentProtocol, addrStr)
		err1 = stuncheck.MappingTestsRFC5389(addrStr)
		if err1 != nil {
			log.Printf("err1:%+v", err1)

			model.NatMappingBehavior = "inconclusive"
			model.NatFilteringBehavior = "inconclusive"
			log.Printf("[%s] RFC5389 NAT detection: inconclusive", currentProtocol)
		}
	case "RFC3489":
		log.Printf("[%s] Trying RFC 3489 method with server %s", currentProtocol, addrStr)
		err1 = stuncheck.MappingTestsRFC3489(addrStr)
		if err1 != nil {
			log.Printf("err1:%+v", err1)

			model.NatMappingBehavior = "inconclusive"
			model.NatFilteringBehavior = "inconclusive"
			log.Printf("[%s] RFC3489 NAT detection: inconclusive", currentProtocol)
		}
	}
	if model.NatMappingBehavior != "inconclusive" && model.NatFilteringBehavior != "inconclusive" &&
		model.NatMappingBehavior != "" && model.NatFilteringBehavior != "" {
		log.Printf("[%s] Successfully determined NAT type using %s with server %s", currentProtocol, rfcMethod, addrStr)
		return true, nil
	}
	return false, nil
}

func GetNatType() string {
	model.EnableLoger = false
	// Check for Open Internet type before determining final result
	if isOpenInternetType() {
		return "OpenPublic"
	}
	mp := make(map[string]int, 8)
	gostunFlag := flag.NewFlagSet("gostun", flag.ContinueOnError)
	gostunFlag.IntVar(&model.Verbose, "verbose", 0, "Set verbosity level")
	gostunFlag.IntVar(&model.Timeout, "timeout", 3, "Set timeout in seconds for STUN server response")
	gostunFlag.StringVar(&model.AddrStr, "server", "stun.voipgate.com:3478", "Specify STUN server address")
	gostunFlag.BoolVar(&model.EnableLoger, "e", false, "Enable logging functionality")
	gostunFlag.StringVar(&model.IPVersion, "type", "ipv4", "Specify ip test version: ipv4, ipv6 or both")
	gostunFlag.Parse(os.Args[1:])
	var addrStrList []string
	var originalIPVersion = model.IPVersion
	if strings.Contains(os.Args[0], "-server") || model.AddrStr != "stun.voipgate.com:3478" {
		addrStrList = []string{model.AddrStr}
	} else {
		addrStrList = model.GetDefaultServers(model.IPVersion)
	}
	// RFC methods in order of preference: 5780 -> 5389 -> 3489
	rfcMethods := []string{"RFC5780", "RFC5389", "RFC3489"}
	successfulDetection := false
	for _, rfcMethod := range rfcMethods {
		if successfulDetection {
			break
		}
		for _, addrStr := range addrStrList {
			model.NatMappingBehavior = ""
			model.NatFilteringBehavior = ""
			currentProtocol := "ipv4"
			if originalIPVersion == "both" {
				if strings.Contains(addrStr, "[") && strings.Contains(addrStr, "]") &&
					!strings.Contains(addrStr, ".") {
					currentProtocol = "ipv6"
					model.IPVersion = "ipv6"
				} else {
					currentProtocol = "ipv4"
					model.IPVersion = "ipv4"
				}
			} else {
				currentProtocol = originalIPVersion
			}
			if model.EnableLoger {
				model.Log.Infof("Testing server %s with protocol %s using %s", addrStr, currentProtocol, rfcMethod)
			}
			_, err := tryRFCMethod(addrStr, rfcMethod)
			if err != nil && model.EnableLoger {
				model.Log.Warnf("[%s] Error with %s method: %v", currentProtocol, rfcMethod, err)
			}
			model.IPVersion = originalIPVersion
			res := stuncheck.CheckType()
			mp[res]++
			if model.EnableLoger {
				model.Log.Warnf("[%s] Server %s failed to determine NAT type using %s, trying next server", currentProtocol, addrStr, rfcMethod)
			}
		}
		if !successfulDetection && model.EnableLoger {
			model.Log.Warnf("All servers failed with %s method, trying next RFC method", rfcMethod)
		}
	}
	maxCount := 0
	res := ""
	for k, v := range mp {
		if v > maxCount {
			maxCount = v
			res = k
		}
	}
	return res
}

func isOpenInternetType() bool {
	// Get local IP addresses
	localIPs := util.GetLocalIPStat()
	if len(localIPs) == 0 {
		return false
	}

	// Get external IP from STUN server
	geoData, err := reverseproxy.GetGeoData()
	if err != nil {
		log.Printf("Failed to get geo data: %v", err)
		return false
	}

	extIP := geoData.Status

	ip, err := getLocalIP()
	if err != nil {
		return false
	}
	if extIP == ip {
		return true
	}
	return false
}

// testChangeRequest tests the CHANGE-REQUEST functionality
// by sending a request with flags 0x00000006 (change IP and port)
func testChangeRequest() bool {
	// Using a known STUN server
	stunServer := "stun.voipgate.com:3478"

	conn, err := net.Dial("udp", stunServer)
	if err != nil {
		log.Printf("Failed to connect to STUN server: %v", err)
		return false
	}
	defer conn.Close()

	// Create a STUN binding request with CHANGE-REQUEST attribute
	msg := stun.MustBuild(stun.TransactionID, stun.BindingRequest)

	// Add CHANGE-REQUEST attribute with value 0x00000006 (change both IP and port)
	changeReqValue := []byte{0x00, 0x00, 0x00, 0x06}
	msg.Add(stun.AttrChangeRequest, changeReqValue)
	// Send the request
	_, err = conn.Write(msg.Raw)
	if err != nil {
		log.Printf("Failed to send STUN request: %v", err)
		return false
	}

	// Set a read deadline
	conn.SetReadDeadline(time.Now().Add(5 * time.Second))

	// Read the response
	buf := make([]byte, 1024)
	n, err := conn.Read(buf)
	if err != nil {
		log.Printf("Failed to read STUN response: %v", err)
		return false
	}

	// Parse the response
	response := &stun.Message{
		Raw: buf[:n],
	}
	if err := response.Decode(); err != nil {
		log.Printf("Failed to decode STUN response: %v", err)
		return false
	}

	// Check if we got a valid response
	if response.Type.Class == stun.ClassSuccessResponse {
		// Successfully received response from different IP and port
		// This indicates Open Internet connection
		return true
	}

	return false
}
func getLocalIP() (string, error) {
	conn, err := net.Dial("udp", "8.8.8.8:80")
	if err != nil {
		return "", err
	}
	defer conn.Close()

	localAddr := conn.LocalAddr().(*net.UDPAddr)
	return localAddr.IP.String(), nil
}
