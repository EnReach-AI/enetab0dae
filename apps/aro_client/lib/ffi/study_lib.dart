import 'dart:ffi';
import 'dart:io';
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
  static bool _inited = false;

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

  static DynamicLibrary _open() {
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

    // Try multiple possible dylib locations
    final candidates = [
      // Standard macOS app bundle: MyApp.app/Contents/MacOS/myapp -> MyApp.app/Contents/Frameworks/
      '${exeDir.path}/../../Frameworks/libstudy.dylib',
      // Direct relative path from executable
      '${exeDir.path}/../Frameworks/libstudy.dylib',
      // Near executable
      '${exeDir.path}/libstudy.dylib',
      // Fallback: current directory
      './libstudy.dylib',
      // Absolute path in common location
      '/usr/local/lib/libstudy.dylib',
    ];

    print('StudyLib: macOS dylib candidates: $candidates');

    for (final dylibPath in candidates) {
      final file = File(dylibPath);
      final exists = file.existsSync();
      final pathToOpen = exists ? file.resolveSymbolicLinksSync() : dylibPath;
      print('[StudyLib] Trying dylib at: $pathToOpen (exists: $exists)');

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

    // If no candidates work, throw with helpful error
    throw UnsupportedError(
        'libstudy.dylib not found. Tried:\n${candidates.join('\n')}\n'
        'Executable path: $exePath\n'
        'Executable dir: ${exeDir.path}');
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
