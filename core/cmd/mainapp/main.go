package main

import (
	"aro-ext-app/core/internal/api_client"
	"aro-ext-app/core/internal/constant"
	"aro-ext-app/core/internal/crypto"
	"aro-ext-app/core/internal/storage"
	"aro-ext-app/core/internal/ws_client"
	"fmt"
	"log"
)

// Global variables
var (
	apiClient  *api_client.APIClient
	wsClient   *ws_client.WSClient
	keyPair    *crypto.KeyPair
	clientID   string
	baseAPIURL = constant.HTTP_SERVER_ENDPOINT
	baseWSURL  = constant.WS_SERVER_ENDPOINT
	storageApi *storage.Storage
)

func main() {
	up, err := apiClient.NodeSignUp()
	if err != nil {
		fmt.Printf("Error: %v", err)
		return
	}

	fmt.Printf("NodeSignUp response: %+v\n", up)
	stat, err := apiClient.GetNodeStat()
	fmt.Printf("NodeStat response: %+v\n", stat)
	rewards, _ := apiClient.GetRewards()
	fmt.Printf("Rewards response: %+v\n", rewards)

	err = wsClient.Connect()
	if err != nil {
		log.Printf("WebSocket connection error: %v", err)
		return
	}

}

func init() {
	// try to load keypair from current directory
	var err error
	keyPair, err = crypto.GetOrCreateKeyPair("")
	if err != nil {
		log.Printf("Warning: unable to load keypair during package initialization: %v", err)
		return
	}
	log.Println("libstudy package initialization: keypair auto-loaded/generated")

	// auto initialize clientID and apiClient
	clientID = crypto.GenerateClientID()
	apiClient = api_client.NewAPIClient(baseAPIURL, clientID, keyPair)
	log.Printf("API client auto-initialized with URL: %+v, ClientID: %s", apiClient, clientID)

	// auto initialize WebSocket client
	log.Printf("WebSocket client initialized with URL: %s", baseWSURL)
}
