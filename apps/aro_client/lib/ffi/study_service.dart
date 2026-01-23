import 'dart:ffi';
import 'dart:io';
import 'dart:convert';
import 'package:ffi/ffi.dart';
import 'study_bindings.dart';

class StudyService {
  StudyService._internal();
  static final StudyService instance = StudyService._internal();

  String nodeSignUp() {
    final ptr = StudyBindings.nodeSignUp();
    return _handleResult(ptr);
  }

  String nodeReportBaseInfo(String sysInfoJSON) {
    final sysInfoPtr = sysInfoJSON.toNativeUtf8();
    final resultPtr = StudyBindings.nodeReportBaseInfo(sysInfoPtr);
    malloc.free(sysInfoPtr);
    return _handleResult(resultPtr);
  }

  String getNodeStat() {
    final ptr = StudyBindings.getNodeStat();
    return _handleResult(ptr);
  }

  String getRewards() {
    final ptr = StudyBindings.getRewards();
    return _handleResult(ptr);
  }

  // Modified to match usage in main.dart
  String nodeInit(String dirPath, Map<String, dynamic> config) {
    // Note: The C header defines InitLibstudy as taking arguments.

    // Change current working directory to dirPath to allow libstudy to write files
    try {
      Directory.current = dirPath;
      print('Successfully changed directory to $dirPath');
    } catch (e) {
      print('Error changing directory: $e');
    }

    final configJson = jsonEncode(config);
    final configPtr = configJson.toNativeUtf8();
    final ptr = StudyBindings.initLibstudy(configPtr);

    malloc.free(ptr);
    malloc.free(configPtr);

    // const configJson = "{"
    //     "\"sn\": \"NLYN2Q0PYRAFQOWHK5R\","
    //     "\"token\": \"1\","
    //     "\"tunnel_id\": \"4dd56d7f-df87-4f7b-9dd3-5f74465d8f74\","
    //     "\"proxy_server_ip\": \"127.0.0.1\","
    //     "\"proxy_server_port\": 8000,"
    //     "\"local_port\": 10800,"
    //     "\"nat_type\": 1,"
    //     "\"fixed_port\": 10800"
    //     "}";

    // try {
    //   const configJson = {
    //     "sn": "LITEARO1L9NMAUHM",
    //     "token": "1",
    //     "tunnel_id": "4dd56d7f-df87-4f7b-9dd3-5f74465d8f74",
    //     "proxy_server_ip": "127.0.0.1",
    //     "proxy_server_port": 8000,
    //     "local_port": 10800,
    //     "nat_type": 1,
    //     "fixed_port": 10800
    //   };
    //   final configJsonPtr = configJson.toString().toNativeUtf8();
    //   final startProxyPtr = StudyBindings.startProxy(configJsonPtr);
    //   malloc.free(configJsonPtr);
    //   print(
    //       'wwwwwwwwwwww------wwwww: $startProxyPtr hhhhhhhhhh---hhh $configJsonPtr');
    // } catch (e) {
    //   print('Error in startProxy: $e');
    // }

    return _handleResult(ptr);
  }

  String getCurrentVersion() {
    final ptr = StudyBindings.getCurrentVersion();
    return _handleResult(ptr);
  }

  String getLastVersion() {
    final ptr = StudyBindings.getLastVersion();
    return _handleResult(ptr);
  }

  String _handleResult(Pointer<Utf8> ptr) {
    if (ptr == nullptr) return '';
    // 直接转换字符串，不释放内存
    // Go 的 C.CString() 分配的内存由 Go 运行时管理
    // 不能用 Dart 的 malloc.free() 释放，否则 Windows 会崩溃
    final str = ptr.toDartString();
    return str;
  }
}
