import 'package:path_provider/path_provider.dart';
import 'dart:io';

Future<String> getAppSupportDir() async {
  try {
    final dir = await getApplicationSupportDirectory();
    final appDir = Directory('${dir.path}/MyApp');

    // Ensure directory exists with proper error handling
    if (!appDir.existsSync()) {
      try {
        appDir.createSync(recursive: true);
        print('Created app directory: ${appDir.path}');
      } catch (e) {
        print('Error creating app directory: $e');
        // Fallback to a writable location
        final tempDir = await getTemporaryDirectory();
        final fallbackDir = Directory('${tempDir.path}/MyApp');
        if (!fallbackDir.existsSync()) {
          fallbackDir.createSync(recursive: true);
        }
        print('Using fallback directory: ${fallbackDir.path}');
        return fallbackDir.path;
      }
    }

    return appDir.path;
  } catch (e) {
    print('Error getting application support directory: $e');
    // Final fallback to temporary directory
    final tempDir = await getTemporaryDirectory();
    final fallbackDir = Directory('${tempDir.path}/MyApp');
    if (!fallbackDir.existsSync()) {
      fallbackDir.createSync(recursive: true);
    }
    return fallbackDir.path;
  }
}
