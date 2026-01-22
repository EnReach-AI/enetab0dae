import 'package:path_provider/path_provider.dart';
import 'dart:io';

Future<String> getAppSupportDir() async {
  final dir = await getApplicationSupportDirectory();
  final appDir = Directory('${dir.path}/MyApp');
  if (!appDir.existsSync()) {
    appDir.createSync(recursive: true);
  }
  return appDir.path;
}
