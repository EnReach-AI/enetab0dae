import 'dart:ffi';
import 'dart:io';
import 'dart:convert';
import 'package:aro_client/services/logger_service.dart';
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

    malloc.free(configPtr);

    try {
      const configJson = "{"
          "\"sn\": \"OLKN4YY4XA9096W5\","
          "\"token\": \"1\","
          "\"tunnel_id\": \"4dd56d7f-df87-4f7b-9dd3-5f74465d8f74\","
          "\"proxy_server_ip\": \"150.109.69.196\","
          "\"proxy_server_port\": 443,"
          "\"local_port\": 22779,"
          "\"nat_type\": 0,"
          "\"fixed_port\": 22779"
          "}";
      final jsonPtr = configJson.toNativeUtf8();

      final startProxyPtr = StudyBindings.startProxy(jsonPtr);
      final result = startProxyPtr.toDartString();
      malloc.free(jsonPtr);

      final getProxyWorkerStatus = StudyBindings.getProxyWorkerStatus();
      final result2 = getProxyWorkerStatus.toDartString();

      LoggerService().info('GetProxyWorkerStatus: $result2 -------  $result');
      print(
          'wwwwwwwwwwww------wwwww:  hhhhhhhhhh---hhh $jsonPtr  $getProxyWorkerStatus');
    } catch (e) {
      LoggerService().info('Error in startProxy: ${DateTime.now()} $e');
      print('Error in startProxy: $e');
    }

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

  String getWSClientStatus() {
    final ptr = StudyBindings.getWSClientStatus();
    return _handleResult(ptr);
  }

  String startWSClient() {
    final ptr = StudyBindings.startWSClient();
    return _handleResult(ptr);
  }
}
