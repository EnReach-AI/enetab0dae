type NATProbeTask struct {
	Type 	  string        `json:"type"`          // 任务类型，例如 "nat_probe"
	TaskId      string `json:"task_id"`      // 主探测任务ID
	SubTaskId   string `json:"sub_task_id"`  // 子探测任务ID
	CheckerIp   string `json:"checker_ip"`   // Checker 节点 IP
	CheckerPort uint32 `json:"checker_port"` // Checker 节点端口
}