package constant

import "time"

type OtaProgram string

const (
	PROGRAM_APP OtaProgram = "aro-app"
)

const (

	VERSION string = "0.0.14"
)

const (
	ENV                       = "dev"
	MAX_LOG_SIZE              = 10 * 1024 * 1024
	RETAIN_LOG_SIZE           = 1 * 1024 * 1024
	LOG_CHECK_INTERVAL        = 5 * time.Minute
)
