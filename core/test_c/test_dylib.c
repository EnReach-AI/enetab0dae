#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

// 引入动态库头文件
#include "../bin/libstudy.h"

// 辅助函数：打印返回的 JSON 结果
void print_result(const char *function_name, char *result)
{
    printf("\n=== %s ===\n", function_name);
    if (result != NULL)
    {
        printf("%s\n", result);
        free(result); // 释放 Go 分配的内存
    }
    else
    {
        printf("返回 NULL\n");
    }
}

int main()
{
    printf("========================================\n");
    printf("直接调用 libstudy.dylib 测试程序\n");
    printf("========================================\n");

    // 1. 测试启动 Proxy Worker
    printf("\n[测试 1] 启动 Proxy Worker...\n");

    const char *config_json = "{"
                              "\"sn\": \"NLYN2Q0PYRAFQOWHK5R\","
                              "\"token\": \"1\","
                              "\"tunnel_id\": \"4dd56d7f-df87-4f7b-9dd3-5f74465d8f74\","
                              "\"proxy_server_ip\": \"127.0.0.1\","
                              "\"proxy_server_port\": 8000,"
                              "\"local_port\": 10800,"
                              "\"nat_type\": 1,"
                              "\"fixed_port\": 10800"
                              "}";

    char *start_result = StartProxyWorker((char *)config_json);
    print_result("StartProxyWorker", start_result);

    // 等待服务启动
    printf("\n等待 2 秒让服务完全启动...\n");
    sleep(2);

    // 2. 测试获取状态
    printf("\n[测试 2] 获取 Worker 状态...\n");
    char *status_result = GetProxyWorkerStatus();
    print_result("GetProxyWorkerStatus", status_result);

    // 3. 测试检查是否运行
    printf("\n[测试 3] 检查 Worker 是否运行...\n");
    char *running_result = IsProxyWorkerRunning();
    print_result("IsProxyWorkerRunning", running_result);

    sleep(10000);

    // // 等待一段时间
    // printf("\n等待 3 秒...\n");
    // sleep(3);

    // // 4. 测试重启
    // printf("\n[测试 4] 重启 Worker...\n");
    // char *restart_result = RestartProxyWorker();
    // print_result("RestartProxyWorker", restart_result);

    // // 等待重启完成
    // printf("\n等待 2 秒让服务重启...\n");
    // sleep(2);

    // // 5. 再次获取状态
    // printf("\n[测试 5] 重启后获取状态...\n");
    // char *status_result2 = GetProxyWorkerStatus();
    // print_result("GetProxyWorkerStatus (after restart)", status_result2);

    // // 6. 测试停止
    // printf("\n[测试 6] 停止 Worker...\n");
    // char *stop_result = StopProxyWorker();
    // print_result("StopProxyWorker", stop_result);

    // // 等待停止完成
    // printf("\n等待 2 秒让服务完全停止...\n");
    // sleep(2);

    // // 7. 验证已停止
    // printf("\n[测试 7] 验证 Worker 已停止...\n");
    // char *running_result2 = IsProxyWorkerRunning();
    // print_result("IsProxyWorkerRunning (after stop)", running_result2);

    // printf("\n========================================\n");
    // printf("✅ 所有测试完成！\n");
    // printf("========================================\n");

    return 0;
}
