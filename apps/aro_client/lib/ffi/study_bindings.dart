import 'dart:ffi';
import 'dart:io' show Platform;
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

class StudyBindings {
  static final _lib = StudyLibrary.instance;
  // Use DynamicLibrary.process() on Linux/macOS/Android, msvcrt.dll on Windows
  static final _stdlib = Platform.isWindows
      ? DynamicLibrary.open('msvcrt.dll')
      : DynamicLibrary.process();

  static final chdir = _stdlib.lookupFunction<ChdirC, ChdirDart>(
      Platform.isWindows ? '_chdir' : 'chdir');

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

  static final getCurrentVersion =
      _lib.lookupFunction<GetCurrentVersionC, GetCurrentVersionDart>(
          'GetCurrentVersion');

  static final getLastVersion = _lib
      .lookupFunction<GetLastVersionC, GetLastVersionDart>('GetLastVersion');
}
