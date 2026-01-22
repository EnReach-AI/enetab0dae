import 'dart:ffi';
import 'dart:io';

final DynamicLibrary _lib = () {
  if (Platform.isMacOS) {
    return DynamicLibrary.open('libmining-1.dylib');
  }
  throw UnsupportedError('Unsupported platform');
}();


/// ================================
/// 2️⃣ void ExtensionStart()
/// C: void ExtensionStart(void)
/// ================================
typedef _ExtensionStartNative = Void Function();
typedef _ExtensionStartDart = void Function();

final _ExtensionStartDart extensionStart =
    _lib.lookupFunction<_ExtensionStartNative, _ExtensionStartDart>(
  '_ExtensionStart',
);

/// ================================
/// 3️⃣ int NodeGetStatus()
/// C: int NodeGetStatus(void)
/// ================================
typedef _NodeGetStatusNative = Int32 Function();
typedef _NodeGetStatusDart = int Function();

final _NodeGetStatusDart nodeGetStatus =
    _lib.lookupFunction<_NodeGetStatusNative, _NodeGetStatusDart>(
  '_NodeGetStatus',
);
