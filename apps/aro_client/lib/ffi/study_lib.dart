import 'dart:ffi';
import 'dart:io';
import 'package:aro_client/components/path_provider.dart';
import 'package:aro_client/services/logger_service.dart';
import 'package:ffi/ffi.dart';

// Win32 MessageBox API
typedef MessageBoxC = Int32 Function(
    IntPtr hWnd, Pointer<Utf8> lpText, Pointer<Utf8> lpCaption, Uint32 uType);
typedef MessageBoxDart = int Function(
    int hWnd, Pointer<Utf8> lpText, Pointer<Utf8> lpCaption, int uType);

class StudyLibrary {
  StudyLibrary._internal();

  static DynamicLibrary? _lib;
  static String? _overridePath;

  static DynamicLibrary get instance {
    _lib ??= _open();
    return _lib!;
  }

  static void ensureInitialized() {
    LoggerService().info('initializing StudyLibrary FFI');

    try {
      _lib ??= _open();
    } catch (e) {
      LoggerService().info('initializing error StudyLibrary FFI', e);

      if (Platform.isWindows) {
        _showWindowsErrorDialog(
            'Failed to load core library (libstudy.dll).\n\n'
            'Please ensure libstudy.dll is in the same directory as the executable.\n\n'
            'Error details:\n$e');
      }
      rethrow;
    }
  }

  static void setOverridePath(String? path) {
    _overridePath = path;
  }

  static DynamicLibrary _open() {
    if (_overridePath != null) {
      final file = File(_overridePath!);
      final exists = file.existsSync();
      if (exists) {
        try {
          final lib = DynamicLibrary.open(file.path);
          print('[StudyLib] Loaded from override path: ${file.path}');
          return lib;
        } catch (e) {
          print('[StudyLib] Failed to load override path: $e');
        }
      }
    }

    if (Platform.isAndroid) {
      return DynamicLibrary.open('libstudy.so');
    }

    if (Platform.isWindows) {
      final exePath = Platform.resolvedExecutable;
      final exeDir = Directory(exePath).parent;

      // Try multiple possible DLL locations for Windows
      final candidates = [
        // Next to executable (typical location for Flutter releases)
        '${exeDir.path}/libstudy.dll',
        // In app directory
        'libstudy.dll',
        // Windows PATH lookup
        'libstudy',
      ];
      LoggerService().info(
        'candidates:',
        candidates,
      );
      LoggerService().info('exePath:', exePath);
      LoggerService().info('exeDir:', exeDir);

      for (final dllPath in candidates) {
        final file = File(dllPath);
        final exists = file.existsSync();
        print('[StudyLib] Trying DLL at: $dllPath (exists: $exists)');
        LoggerService()
            .info('[StudyLib] Trying DLL at: $dllPath (exists: $exists)');

        if (exists) {
          try {
            final lib = DynamicLibrary.open(dllPath);
            print('[StudyLib] Successfully loaded from: $dllPath');
            LoggerService()
                .info('[StudyLib] Successfully loaded from: $dllPath');

            return lib;
          } catch (e) {
            print('[StudyLib] Failed to load from $dllPath: $e');
            LoggerService().info('[StudyLib] Failed to load from $dllPath: $e');

            continue;
          }
        }
      }

      // Try without checking existence (Windows PATH lookup)
      try {
        print('[StudyLib] Trying to load libstudy.dll from Windows PATH');
        final lib = DynamicLibrary.open('libstudy.dll');
        print('[StudyLib] Successfully loaded libstudy.dll from PATH');
        return lib;
      } catch (e) {
        print('[StudyLib] Failed to load libstudy.dll: $e');
        LoggerService().info('[StudyLib] Failed to load libstudy.dll: $e');

        throw UnsupportedError(
            'libstudy.dll not found. Tried:\n${candidates.join('\n')}\n'
            'Executable path: $exePath\n'
            'Executable dir: ${exeDir.path}\n'
            'Make sure libstudy.dll is placed next to the executable or in PATH.');
      }
    }

    if (Platform.isLinux) {
      final exePath = Platform.resolvedExecutable;
      final exeDir = Directory(exePath).parent;

      final candidates = [
        // Next to executable
        '${exeDir.path}/lib/libstudy.so',
        '${exeDir.path}/libstudy.so',
        // Current directory
        './libstudy.so',
        // System library path
        'libstudy.so',
      ];

      for (final soPath in candidates) {
        final file = File(soPath);
        final exists = file.existsSync();
        print('[StudyLib] Trying SO at: $soPath (exists: $exists)');

        if (exists) {
          try {
            final lib = DynamicLibrary.open(soPath);
            print('[StudyLib] Successfully loaded from: $soPath');
            return lib;
          } catch (e) {
            print('[StudyLib] Failed to load from $soPath: $e');
            continue;
          }
        }
      }

      try {
        final lib = DynamicLibrary.open('libstudy.so');
        print('[StudyLib] Successfully loaded libstudy.so');
        return lib;
      } catch (e) {
        throw UnsupportedError(
            'libstudy.so not found. Tried:\n${candidates.join('\n')}\n'
            'Error: $e');
      }
    }

    if (!Platform.isMacOS) {
      throw UnsupportedError(
          'Only macOS, Windows, Linux and Android are supported');
    }

    final exePath = Platform.resolvedExecutable;
    final exeDir = Directory(exePath).parent;
    final abi = Abi.current();

    Directory? findContentsDir(Directory start) {
      var current = start;
      for (var i = 0; i < 6; i++) {
        final name = current.path.split(Platform.pathSeparator).last;
        if (name == 'Contents') return current;

        final parent = current.parent;
        if (parent.path == current.path) break;
        current = parent;
      }

      return null;
    }

    final contentsDir = findContentsDir(exeDir);
    final frameworksDir = contentsDir != null
        ? Directory('${contentsDir.path}/Frameworks')
        : exeDir.parent;
    final dylibNames = ['libstudy-arm.dylib', 'libstudy-amd.dylib'];
    final home = Platform.environment['HOME'];
    final appSupportCandidates = <String>[];
    if (home != null && home.isNotEmpty) {
      final appSupportDir =
          '$home/Library/Application Support/com.aro.aroApp/MyApp';
      for (final name in dylibNames) {
        appSupportCandidates.add('$appSupportDir/$name');
      }
    }

    // Prefer user-updated dylib in Application Support. If found and loadable, stop here.
    for (final dylibPath in appSupportCandidates) {
      final file = File(dylibPath);
      final exists = file.existsSync();
      if (!exists) continue;

      final pathToOpen = file.resolveSymbolicLinksSync();
      print('[StudyLib] Trying user Application Support dylib at: $pathToOpen');
      try {
        final lib = DynamicLibrary.open(pathToOpen);
        print('[StudyLib] Loaded from Application Support: $pathToOpen');
        return lib;
      } catch (e) {
        print(
            '[StudyLib] Failed to load Application Support dylib at $pathToOpen: $e');
      }
    }

    // Try bundled/adjacent locations
    final candidates = <String>[
      for (final name in dylibNames) '${frameworksDir.path}/$name',
      for (final name in dylibNames) '${exeDir.path}/$name',
      if (contentsDir != null)
        for (final name in dylibNames) '${contentsDir.path}/MacOS/$name',
    ];

    final uniqueCandidates = <String>[];
    final seen = <String>{};
    for (final path in candidates) {
      if (seen.add(path)) {
        uniqueCandidates.add(path);
      }
    }

    final appSupportLog = appSupportCandidates.isNotEmpty
        ? appSupportCandidates.first.replaceAll(RegExp('libstudy-.*'), '')
        : 'n/a';

    print(
        'StudyLib: macOS exePath: $exePath, exeDir: ${exeDir.path}, contentsDir: ${contentsDir?.path}, frameworksDir: ${frameworksDir.path}, appSupport: $appSupportLog');
    print('StudyLib: macOS dylib candidates (bundled): $uniqueCandidates');
    LoggerService()
        .info('StudyLib: macOS dylib candidates (bundled): $uniqueCandidates');

    for (final dylibPath in uniqueCandidates) {
      final file = File(dylibPath);
      final exists = file.existsSync();
      final pathToOpen = exists ? file.resolveSymbolicLinksSync() : dylibPath;
      print('[StudyLib] Trying dylib at: $pathToOpen (exists: $exists)');
      LoggerService()
          .info('[StudyLib] Trying dylib at: $pathToOpen (exists: $exists)');

      if (exists) {
        try {
          final lib = DynamicLibrary.open(pathToOpen);
          print('[StudyLib] Successfully loaded from: $pathToOpen');
          return lib;
        } catch (e) {
          print('[StudyLib] Failed to load from $pathToOpen: $e');
          continue;
        }
      }
    }

    final fallbackName =
        abi == Abi.macosArm64 ? 'libstudy-arm.dylib' : 'libstudy-amd.dylib';

    try {
      print('[StudyLib] Trying fallback dylib by name: $fallbackName');
      final lib = DynamicLibrary.open(fallbackName);
      print('[StudyLib] Successfully loaded fallback: $fallbackName');
      return lib;
    } catch (e) {
      throw UnsupportedError(
          'libstudy-amd/arm.dylib not found. Tried (bundled):\n${uniqueCandidates.join('\n')}\n'
          'Fallback name: $fallbackName\n'
          'Executable path: $exePath\n'
          'Executable dir: ${exeDir.path}\n'
          'Contents dir: ${contentsDir?.path ?? 'n/a'}\n'
          'Frameworks dir: ${frameworksDir.path}\n'
          'App Support dir: $appSupportLog\n'
          'Error: $e');
    }
  }

  static void _showWindowsErrorDialog(String message) {
    try {
      final user32 = DynamicLibrary.open('user32.dll');
      final messageBox =
          user32.lookupFunction<MessageBoxC, MessageBoxDart>('MessageBoxA');

      final text = message.toNativeUtf8();
      final caption = 'Error'.toNativeUtf8();

      const uType = 0x00000000 | 0x00000010 | 0x00040000;

      messageBox(0, text, caption, uType);

      malloc.free(text);
      malloc.free(caption);
    } catch (_) {}
  }
}
