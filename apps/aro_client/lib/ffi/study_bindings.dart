import 'dart:ffi';
import 'dart:io' show Platform;
import 'package:aro_client/services/logger_service.dart';
import 'package:ffi/ffi.dart';
import 'study_lib.dart';

// FFI signature types
typedef NodeSignUpC = Pointer<Utf8> Function();
typedef NodeSignUpDart = Pointer<Utf8> Function();

typedef NodeReportBaseInfoC = Pointer<Utf8> Function(Pointer<Utf8>);
typedef NodeReportBaseInfoDart = Pointer<Utf8> Function(Pointer<Utf8>);

typedef GetNodeStatC = Pointer<Utf8> Function();
typedef GetNodeStatDart = Pointer<Utf8> Function();

typedef GetRewardsC = Pointer<Utf8> Function();
typedef GetRewardsDart = Pointer<Utf8> Function();

typedef InitLibstudyC = Pointer<Utf8> Function(Pointer<Utf8>);
typedef InitLibstudyDart = Pointer<Utf8> Function(Pointer<Utf8>);

typedef GetCurrentVersionC = Pointer<Utf8> Function();
typedef GetCurrentVersionDart = Pointer<Utf8> Function();

typedef GetLastVersionC = Pointer<Utf8> Function();
typedef GetLastVersionDart = Pointer<Utf8> Function();

typedef ChdirC = Int32 Function(Pointer<Utf8>);
typedef ChdirDart = int Function(Pointer<Utf8>);

T? _tryLookup<T extends Function>(
    DynamicLibrary lib, String name, T Function(DynamicLibrary) lookup) {
  try {
    return lookup(lib);
  } catch (e, s) {
    LoggerService().error('[StudyBindings] Failed to lookup "$name"', e, s);
    return null;
  }
}

class StudyBindings {
  StudyBindings._();

  static DynamicLibrary get _lib => StudyLibrary.instance;

  static DynamicLibrary get _stdlib => _stdlibCached ??= Platform.isWindows
      ? DynamicLibrary.open('msvcrt.dll')
      : DynamicLibrary.process();
  static DynamicLibrary? _stdlibCached;

  // --- lazy + guarded lookups ---

  static ChdirDart? _chdir;
  static ChdirDart get chdir => _chdir ??= _tryLookup(
        _stdlib,
        'chdir',
        (lib) => lib.lookupFunction<ChdirC, ChdirDart>(
            Platform.isWindows ? '_chdir' : 'chdir'),
      )!;

  static NodeSignUpDart? _nodeSignUp;
  static NodeSignUpDart get nodeSignUp => _nodeSignUp ??= _tryLookup(
        _lib,
        'NodeSignUp',
        (lib) => lib.lookupFunction<NodeSignUpC, NodeSignUpDart>('NodeSignUp'),
      )!;

  static NodeReportBaseInfoDart? _nodeReportBaseInfo;
  static NodeReportBaseInfoDart get nodeReportBaseInfo =>
      _nodeReportBaseInfo ??= _tryLookup(
        _lib,
        'NodeReportBaseInfo',
        (lib) =>
            lib.lookupFunction<NodeReportBaseInfoC, NodeReportBaseInfoDart>(
                'NodeReportBaseInfo'),
      )!;

  static GetNodeStatDart? _getNodeStat;
  static GetNodeStatDart get getNodeStat => _getNodeStat ??= _tryLookup(
        _lib,
        'GetNodeStat',
        (lib) =>
            lib.lookupFunction<GetNodeStatC, GetNodeStatDart>('GetNodeStat'),
      )!;

  static GetRewardsDart? _getRewards;
  static GetRewardsDart get getRewards => _getRewards ??= _tryLookup(
        _lib,
        'GetRewards',
        (lib) => lib.lookupFunction<GetRewardsC, GetRewardsDart>('GetRewards'),
      )!;

  static InitLibstudyDart? _initLibstudy;
  static InitLibstudyDart get initLibstudy => _initLibstudy ??= _tryLookup(
        _lib,
        'InitLibstudy',
        (lib) =>
            lib.lookupFunction<InitLibstudyC, InitLibstudyDart>('InitLibstudy'),
      )!;

  static GetCurrentVersionDart? _getCurrentVersion;
  static GetCurrentVersionDart get getCurrentVersion =>
      _getCurrentVersion ??= _tryLookup(
        _lib,
        'GetCurrentVersion',
        (lib) => lib.lookupFunction<GetCurrentVersionC, GetCurrentVersionDart>(
            'GetCurrentVersion'),
      )!;

  static GetLastVersionDart? _getLastVersion;
  static GetLastVersionDart get getLastVersion =>
      _getLastVersion ??= _tryLookup(
        _lib,
        'GetLastVersion',
        (lib) => lib.lookupFunction<GetLastVersionC, GetLastVersionDart>(
            'GetLastVersion'),
      )!;

  /// Reset all cached lookups (used after hot-reloading a new library).
  static void reset() {
    _stdlibCached = null;
    _chdir = null;
    _nodeSignUp = null;
    _nodeReportBaseInfo = null;
    _getNodeStat = null;
    _getRewards = null;
    _initLibstudy = null;
    _getCurrentVersion = null;
    _getLastVersion = null;
  }
}
