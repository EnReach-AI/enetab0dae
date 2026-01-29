import 'dart:ffi';
import 'package:ffi/ffi.dart';
import 'study_lib.dart';

// FFI signature types
typedef NodeSignUpC = Pointer<Utf8> Function();
typedef NodeSignUpDart = Pointer<Utf8> Function();

typedef NodeReportBaseInfoC = Pointer<Utf8> Function(Pointer<Utf8>);
typedef NodeReportBaseInfoDart = Pointer<Utf8> Function(Pointer<Utf8>);

typedef GetNodeStatC = Pointer<Utf8> Function();
typedef GetNodeStatDart = Pointer<Utf8> Function();

typedef StartProxy = Pointer<Utf8> Function();

typedef GetRewardsC = Pointer<Utf8> Function();
typedef GetRewardsDart = Pointer<Utf8> Function();

typedef InitLibstudyC = Pointer<Utf8> Function(Pointer<Utf8>);
typedef InitLibstudyDart = Pointer<Utf8> Function(Pointer<Utf8>);

typedef InitStartProxyC = Pointer<Utf8> Function(Pointer<Utf8>);
typedef InitStartProxyDart = Pointer<Utf8> Function(Pointer<Utf8>);

typedef GetProxyWorkerStatusC = Pointer<Utf8> Function();
typedef GetProxyWorkerStatusDart = Pointer<Utf8> Function();

typedef GetCurrentVersionC = Pointer<Utf8> Function();
typedef GetCurrentVersionDart = Pointer<Utf8> Function();

typedef GetLastVersionC = Pointer<Utf8> Function();
typedef GetLastVersionDart = Pointer<Utf8> Function();

typedef GetWSClientStatusC = Pointer<Utf8> Function();
typedef GetWSClientStatusDart = Pointer<Utf8> Function();

typedef StartWSClientC = Pointer<Utf8> Function();
typedef StartWSClientDart = Pointer<Utf8> Function();

typedef ChdirC = Int32 Function(Pointer<Utf8>);
typedef ChdirDart = int Function(Pointer<Utf8>);

class StudyBindings {
  static final _lib = StudyLibrary.instance;
  // Use DynamicLibrary.process() for standard C functions like chdir
  static final _stdlib = DynamicLibrary.process();

  static final chdir = _stdlib.lookupFunction<ChdirC, ChdirDart>('chdir');

  static final nodeSignUp =
      _lib.lookupFunction<NodeSignUpC, NodeSignUpDart>('NodeSignUp');

  static final nodeReportBaseInfo =
      _lib.lookupFunction<NodeReportBaseInfoC, NodeReportBaseInfoDart>(
          'NodeReportBaseInfo');

  static final getNodeStat =
      _lib.lookupFunction<GetNodeStatC, GetNodeStatDart>('GetNodeStat');

  static final getRewards =
      _lib.lookupFunction<GetRewardsC, GetRewardsDart>('GetRewards');

  static final initLibstudy =
      _lib.lookupFunction<InitLibstudyC, InitLibstudyDart>('InitLibstudy');

  static final startProxy = _lib
      .lookupFunction<InitStartProxyC, InitStartProxyDart>('StartProxyWorker');

  static final getProxyWorkerStatus =
      _lib.lookupFunction<GetProxyWorkerStatusC, GetProxyWorkerStatusDart>(
          'GetProxyWorkerStatus');

  static final getCurrentVersion =
      _lib.lookupFunction<GetCurrentVersionC, GetCurrentVersionDart>(
          'GetCurrentVersion');

  static final getLastVersion = _lib
      .lookupFunction<GetLastVersionC, GetLastVersionDart>('GetLastVersion');

  static final getWSClientStatus =
      _lib.lookupFunction<GetWSClientStatusC, GetWSClientStatusDart>(
          'GetWSClientStatus');

  static final startWSClient =
      _lib.lookupFunction<StartWSClientC, StartWSClientDart>('StartWSClient');
}
