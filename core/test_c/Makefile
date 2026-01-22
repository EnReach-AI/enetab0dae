# Makefile for testing libstudy.dylib

CC = gcc
CFLAGS = -Wall -I../bin
LDFLAGS = -L../bin -lstudy

# 目标文件
TARGET = test_dylib
SOURCE = test_dylib.c

# 默认目标
all: $(TARGET)

# 编译可执行文件
$(TARGET): $(SOURCE)
	@echo "正在编译 C 测试程序..."
	$(CC) $(CFLAGS) -o $(TARGET) $(SOURCE) $(LDFLAGS)
	@echo "✓ 编译完成: $(TARGET)"

# 运行测试
run: $(TARGET)
	@echo "运行测试程序..."
	@echo "设置动态库路径: DYLD_LIBRARY_PATH=../bin"
	DYLD_LIBRARY_PATH=../bin ./$(TARGET)

# 清理
clean:
	@echo "清理生成的文件..."
	rm -f $(TARGET)
	@echo "✓ 清理完成"

# 快速测试（默认）
test: run

# 帮助信息
help:
	@echo "可用的 make 目标："
	@echo "  make          - 编译测试程序"
	@echo "  make run      - 编译并运行测试"
	@echo "  make test     - 同 make run（快捷方式）"
	@echo "  make clean    - 清理生成的文件"
	@echo "  make help     - 显示此帮助信息"
	@echo ""
	@echo "快速测试："
	@echo "  make test     - 一键测试"

.PHONY: all run test clean help
