package workland

import (
	"context"
	"enreach-agent/internal/epoch"
	"enreach-agent/internal/middleapi/service"
	"enreach-agent/util"
	"github.com/duke-git/lancet/v2/concurrency"
	"github.com/shirou/gopsutil/v4/cpu"
	"github.com/shirou/gopsutil/v4/mem"
	"github.com/xiaoxiao-1022/go-iperf"
	"log"
	"time"
)

func SpeedtestTask(ctx context.Context, nodeId string, backendService *service.BackendService, locker *concurrency.KeyedLocker[string]) {
	util.RecoverFromPanic()
	for {
		select {
		case <-ctx.Done():
			return
		default:
			schedulerInfo, err := backendService.GetSchedulerWithInterval(nodeId, 60)
			if err != nil {
				log.Printf("speedtestTask GetScheduler error: %v", err)
			}
			schedulerService := service.NewSchedulerClient(nodeId, schedulerInfo.HostAddress, schedulerInfo.HttpPort)
			speedTestTask, err := schedulerService.CreateSpeedTestTask()
			if err != nil {
				log.Printf("speedtestTask CreateSpeedTestTask error: %v", err)
				time.Sleep(10 * time.Second)
				continue

			}
			if speedTestTask.TaskStart {
				log.Printf("speedtestTask taskId:%+v, start", speedTestTask)
				for {
					targetTime := time.Unix(speedTestTask.StartTime, 0)
					timer := time.NewTimer(time.Until(targetTime))
					<-timer.C
					checkClient := service.NewCheckClient(nodeId, speedTestTask.Host, speedTestTask.HttpPort)
					startSpeedTestTask, err := checkClient.StartSpeedTestTask(speedTestTask.TaskUUID)
					if err != nil {
						log.Printf("speedtestTask StartSpeedTestTask error: %v", err)
						time.Sleep(10 * time.Second)
						continue
					}
					log.Printf("wait get lock speedtestTask: %+v;startSpeedTestTask:%+v", speedTestTask, startSpeedTestTask)
					sumSendChan := make(chan iperf.StreamEndSumReport, 1)
					locker.Do(ctx, "startJob", func() {
						log.Printf("speedtestTask Iperf3test start")
						sumSend := epoch.Iperf3test(startSpeedTestTask, speedTestTask)
						sumSendChan <- sumSend
					})
					cpuPercentChan := make(chan float64, 1)
					go func() {
						percent, err := cpu.Percent(3, false)
						if err != nil {
							log.Printf("failed to get cpu percent: %v\n", err)
							cpuPercentChan <- 0
							return
						}
						cpuPercentChan <- percent[0]
					}()
					memPercentChan := make(chan float64, 1)
					go func() {
						time.Sleep(3 * time.Second)
						virtualMem, err := mem.VirtualMemory()
						if err != nil {
							log.Printf("failed to get memory info: %v\n", err)
							memPercentChan <- 0
							return
						}
						memPercentChan <- virtualMem.UsedPercent
					}()
					cpuPercent := <-cpuPercentChan
					memPerCent := <-memPercentChan
					sumSend := <-sumSendChan
					isMax, _ := isMaxBandWith(sumSend, cpuPercent, memPerCent)
					log.Printf("isMax:%t", isMax)
					speedtestResult := "success"
					if isMax {
						speedtestResult = "failed"
					}

					log.Printf("complete speedtest task taskId:%s, result: %s", speedTestTask.TaskUUID, speedtestResult)
					task, err := checkClient.CompleteSpeedTestTask(speedTestTask.TaskUUID, speedtestResult)
					if err != nil {
						log.Printf("speedtestTask CompleteSpeedTestTask error: %v", err)
						time.Sleep(10 * time.Second)
						continue
					}
					if task || time.Now().UTC().Unix() > speedTestTask.EndTime {
						break
					} else {
						continue
					}
				}
			}
			time.Sleep(1 * time.Hour)
		}
	}
}

func isMaxBandWith(report iperf.StreamEndSumReport, cpuPercent float64, memPercent float64) (bool, float64) {
	//jitter_ms is not as condition of max bandwith
	bandWith := report.BitsPerSecond / 1000 / 1000
	log.Printf("StreamEndSumReport:%+v", report)
	log.Printf("cpuPercent: %f, memPercent: %f, bandWith: %f,lostPercent:%f\n", cpuPercent, memPercent, bandWith, report.LostPercent)
	if cpuPercent > 80 || memPercent > 80 || report.LostPercent > 5 {
		return true, bandWith
	}
	return false, bandWith
}
