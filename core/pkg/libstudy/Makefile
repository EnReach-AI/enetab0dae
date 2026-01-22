.PHONY: test test-v test-short test-race test-coverage bench clean help

# 项目目录
LIBMINING_DIR := /opt/xinyun/web/aro-ext-app/core
TEST_DIR := pkg/libstudy/test

help:
	@echo "libstudy 测试命令"
	@echo ""
	@echo "可用命令:"
	@echo "  make test           运行所有测试"
	@echo "  make test-v         运行所有测试（详细输出）"
	@echo "  make test-short     运行所有测试（跳过长时间测试）"
	@echo "  make test-race      运行所有测试（竞态检测）"
	@echo "  make test-coverage  运行测试并生成覆盖率报告"
	@echo "  make bench          运行性能基准测试"
	@echo "  make bench-mem      运行性能测试并显示内存分配"
	@echo "  make test-api       仅运行 API 客户端测试"
	@echo "  make test-ws        仅运行 WebSocket 测试"
	@echo "  make test-integration 仅运行集成测试"
	@echo "  make clean          清理生成的文件"

# 运行所有测试
test:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -v

# 详细输出
test-v:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -v -race -timeout 30s

# 跳过长时间测试
test-short:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -short -v

# 竞态检测
test-race:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -race -v

# 覆盖率测试
test-coverage:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -cover -v
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -coverprofile=coverage.out
	cd $(LIBMINING_DIR) && go tool cover -html=coverage.out -o coverage.html
	@echo "覆盖率报告已生成: $(LIBMINING_DIR)/coverage.html"

# 性能基准测试
bench:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -bench=. -run=^$$ -v

# 性能测试并显示内存分配
bench-mem:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -bench=. -benchmem -run=^$$ -v

# 仅运行 API 客户端测试
test-api:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -v -run "TestNodeSignUp|TestNodeReportBaseInfo|TestGetNodeStat|TestGetRewards|TestSetAPIURL|TestSetWSURL|TestSetClientID|TestGetAPIURL|TestInitAPIClient"

# 仅运行 WebSocket 测试
test-ws:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -v -run "TestInitWSClient|TestConnectWS|TestDisconnectWS|TestSendWSMessage|TestIsWSConnected"

# 仅运行集成测试
test-integration:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -v -run "TestIntegration|TestAPIClientFlow|TestWSClientFlow"

# 仅运行特定测试 (使用: make test-func name=TestGetNodeStat)
test-func:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -v -run $(name)

# 生成测试报告
test-report:
	cd $(LIBMINING_DIR) && go test ./$(TEST_DIR) -v -json > test-report.json
	@echo "测试报告已生成: $(LIBMINING_DIR)/test-report.json"

# 清理生成的文件
clean:
	cd $(LIBMINING_DIR) && rm -f coverage.out coverage.html test-report.json

# 依赖检查
deps:
	cd $(LIBMINING_DIR) && go mod tidy
	cd $(LIBMINING_DIR) && go mod verify

# 完整测试流程
test-all: clean deps test-v bench-mem test-coverage
	@echo "所有测试完成！"
