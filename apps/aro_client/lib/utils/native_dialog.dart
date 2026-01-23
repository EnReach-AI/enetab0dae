import 'dart:ffi';
import 'dart:io';
import 'package:ffi/ffi.dart';

// Win32 MessageBox API
typedef MessageBoxC = Int32 Function(
    IntPtr hWnd, Pointer<Utf8> lpText, Pointer<Utf8> lpCaption, Uint32 uType);
typedef MessageBoxDart = int Function(
    int hWnd, Pointer<Utf8> lpText, Pointer<Utf8> lpCaption, int uType);

class NativeDialog {
  static void show(String message, {String title = 'Error'}) {
    if (Platform.isWindows) {
      try {
        final user32 = DynamicLibrary.open('user32.dll');
        final messageBox =
            user32.lookupFunction<MessageBoxC, MessageBoxDart>('MessageBoxA');

        final text = message.toNativeUtf8();
        final caption = title.toNativeUtf8();

        // MB_OK | MB_ICONERROR | MB_TOPMOST
        const uType = 0x00000000 | 0x00000010 | 0x00040000;

        messageBox(0, text, caption, uType);

        malloc.free(text);
        malloc.free(caption);
      } catch (e) {
        // If we can't even show a dialog, print to stderr as a last resort
        stderr.writeln('Failed to show native dialog: $e');
        stderr.writeln('Original message: $message');
      }
    } else {
      // For other platforms, just print (macOS/Linux could use similar native APIs but Windows is the main target here)
      print('[$title] $message');
    }
  }
}
