package main

import (
	"aro-ext-app/core/internal/api_client"
	"aro-ext-app/core/internal/constant"
	"aro-ext-app/core/internal/crypto"
	"aro-ext-app/core/internal/storage"
	"log"
	"runtime"
)

// Global variables
var (
	apiClient  *api_client.APIClient
	keyPair    *crypto.KeyPair
	clientID   string
	baseAPIURL = constant.HTTP_SERVER_ENDPOINT
	baseWSURL  = constant.WS_SERVER_ENDPOINT
	storageApi *storage.Storage
)

func main() {
	log.Print(runtime.GOOS)
	log.Println(runtime.GOARCH)
}

// func init() {
// 	// try to load keypair from current directory
// 	var err error
// 	keyPair, err = crypto.GetOrCreateKeyPair("")
// 	if err != nil {
// 		log.Printf("Warning: unable to load keypair during package initialization: %v", err)
// 		return
// 	}
// 	log.Println("libstudy package initialization: keypair auto-loaded/generated")

// 	// auto initialize clientID and apiClient
// 	clientID = crypto.GenerateClientID()
// 	apiClient = api_client.NewAPIClient(baseAPIURL, clientID, keyPair)
// 	log.Printf("API client auto-initialized with URL: %+v, ClientID: %s", apiClient, clientID)
// 	apiResponse,_ := api_client.GetLastVersion(constant.PROGRAM_APP,"dev")
// 	log.Println(*apiResponse)
// 	// auto initialize WebSocket client
// 	log.Printf("WebSocket client initialized with URL: %s", baseWSURL)
// }
