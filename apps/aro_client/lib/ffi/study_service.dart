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
  String nodeInit(Map<String, dynamic> dirPath, Map<String, dynamic> config) {
    print('Directorypath $dirPath');

    final configJson = jsonEncode(config);
    final configPtr = configJson.toNativeUtf8();
    final dirJson = jsonEncode(dirPath);
    final dirPtr = dirJson.toNativeUtf8();
    print('adada $dirPath ------- $config');
    LoggerService()
        .info('StudyService.nodeInit - dirPath: $dirPath, config: $config');
    final ptr = StudyBindings.initLibstudy(dirPtr, configPtr);

    malloc.free(configPtr);
    malloc.free(dirPtr);

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

    final str = ptr.toDartString();
    print('ptr23232---: $str');
    return str;
  }
}
