// #include <stdio.h>
// #include <stdlib.h>
// #include <dlfcn.h>
// #include <string.h>

// typedef char* (*InitLibstudyFunc)(const char*);
// typedef char* (*GetLastVersionFunc)();
// typedef void (*FreeFunc)(void*);

// int main() {
//     void *handle;
//     char *error;
    
//     // 加载共享库
//     handle = dlopen("../", RTLD_LAZY);
//     if (!handle) {
//         fprintf(stderr, "❌ Failed to load libstudy.so: %s\n", dlerror());
//         return 1;
//     }
//     printf("✓ Loaded libstudy.so\n\n");
    
//     // 清除任何现有错误
//     dlerror();
    
//     // 获取 InitLibstudy 函数
//     InitLibstudyFunc InitLibstudy = (InitLibstudyFunc)dlsym(handle, "InitLibstudy");
//     error = dlerror();
//     if (error != NULL) {
//         fprintf(stderr, "❌ Failed to find InitLibstudy: %s\n", error);
//         dlclose(handle);
//         return 1;
//     }
    
//     // 获取 GetLastVersion 函数
//     GetLastVersionFunc GetLastVersion = (GetLastVersionFunc)dlsym(handle, "GetLastVersion");
//     error = dlerror();
//     if (error != NULL) {
//         fprintf(stderr, "❌ Failed to find GetLastVersion: %s\n", error);
//         dlclose(handle);
//         return 1;
//     }
//     printf("✓ Found exported functions\n\n");
    
//     // 先初始化库
//     printf("=== Testing InitLibstudy ===\n");
//     char *initParams = "{\"config\":{\"base_api_url\":\"\",\"base_ws_url\":\"\"}}";
//     char *initResult = InitLibstudy(initParams);
//     if (initResult != NULL) {
//         printf("InitLibstudy Response:\n%s\n\n", initResult);
//         free(initResult);
//     } else {
//         fprintf(stderr, "❌ InitLibstudy returned NULL\n\n");
//     }
    
//     // 测试 GetLastVersion
//     printf("=== Testing GetLastVersion ===\n");
//     char *result = GetLastVersion();
    
//     if (result != NULL) {
//         printf("GetLastVersion Response:\n%s\n\n", result);
        
//         // 验证响应格式
//         if (strstr(result, "\"code\"") != NULL && 
//             strstr(result, "\"message\"") != NULL && 
//             strstr(result, "\"data\"") != NULL) {
//             printf("✓ Response has correct format {code, message, data}\n");
//         } else {
//             printf("❌ Response format is incorrect\n");
//         }
        
//         // 检查是否成功
//         if (strstr(result, "\"code\":200") != NULL || strstr(result, "\"code\": 200") != NULL) {
//             printf("✓ Response code is 200 (success)\n");
//         } else {
//             printf("⚠ Response code is not 200\n");
//         }
        
//         // 检查是否包含版本信息
//         if (strstr(result, "\"version\"") != NULL) {
//             printf("✓ Response contains version field\n");
//         }
        
//         if (strstr(result, "\"url\"") != NULL) {
//             printf("✓ Response contains download URL\n");
//         }
        
//         if (strstr(result, "\"checksum\"") != NULL) {
//             printf("✓ Response contains checksum\n");
//         }
        
//         free(result);
//     } else {
//         fprintf(stderr, "❌ GetLastVersion returned NULL\n");
//     }
    
//     printf("\n========================================\n");
//     printf("Test completed!\n");
//     printf("========================================\n");
    
//     // 关闭共享库
//     dlclose(handle);
//     return 0;
// }
