import 'dart:io';

import 'package:archive/archive.dart';
import 'package:aro_client/components/path_provider.dart';
import 'package:aro_client/services/logger_service.dart';
import 'package:crypto/crypto.dart';
import 'package:path/path.dart' as p;

class LibUpdateService {
  LibUpdateService._internal();
  static final LibUpdateService instance = LibUpdateService._internal();

  Future<Map<String, dynamic>> checkAndUpdateMacOS({
    required Map<String, dynamic> currentVersionMap,
    required Map<String, dynamic> latestVersionMap,
  }) async {
    if (!Platform.isMacOS) {
      return {
        'code': 200,
        'updated': false,
        'message': 'Skip update: not macOS',
      };
    }

    if (currentVersionMap['code'] != 200) {
      return {
        'code': currentVersionMap['code'] ?? 500,
        'updated': false,
        'message': 'Failed to read current version',
      };
    }

    if (latestVersionMap['code'] != 200) {
      return {
        'code': latestVersionMap['code'] ?? 500,
        'updated': false,
        'message': 'Failed to read latest version',
      };
    }

    final currentVersion = (currentVersionMap['data'] ?? '').toString();
    final latestData = latestVersionMap['data'];
    if (latestData is! Map) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Latest version data invalid',
      };
    }

    final latestVersion = (latestData['version'] ?? '').toString();
    if (currentVersion.isEmpty || latestVersion.isEmpty) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Version info missing',
      };
    }

    final compare = _compareVersions(currentVersion, latestVersion);
    if (compare >= 0) {
      return {
        'code': 200,
        'updated': false,
        'message': 'Already up to date',
        'currentVersion': currentVersion,
        'latestVersion': latestVersion,
      };
    }

    final url = (latestData['url'] ?? '').toString();
    final checksum = (latestData['checksum'] ?? '').toString();
    final releaseNotes = (latestData['releaseNotes'] ?? '').toString();

    if (url.isEmpty) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Download url missing',
      };
    }

    return _downloadAndInstall(
      url: url,
      checksum: checksum,
      version: latestVersion,
      fileName: 'libstudy.dylib',
      chmod: true,
      releaseNotes: releaseNotes,
    );
  }

  Future<Map<String, dynamic>> checkAndUpdateAndroid({
    required Map<String, dynamic> currentVersionMap,
    required Map<String, dynamic> latestVersionMap,
  }) async {
    if (!Platform.isAndroid) {
      return {
        'code': 200,
        'updated': false,
        'message': 'Skip update: not Android',
      };
    }

    if (currentVersionMap['code'] != 200) {
      return {
        'code': currentVersionMap['code'] ?? 500,
        'updated': false,
        'message': 'Failed to read current version',
      };
    }

    if (latestVersionMap['code'] != 200) {
      return {
        'code': latestVersionMap['code'] ?? 500,
        'updated': false,
        'message': 'Failed to read latest version',
      };
    }

    final currentVersion = (currentVersionMap['data'] ?? '').toString();
    final latestData = latestVersionMap['data'];
    if (latestData is! Map) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Latest version data invalid',
      };
    }

    final latestVersion = (latestData['version'] ?? '').toString();
    if (currentVersion.isEmpty || latestVersion.isEmpty) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Version info missing',
      };
    }

    final compare = _compareVersions(currentVersion, latestVersion);
    if (compare >= 0) {
      return {
        'code': 200,
        'updated': false,
        'message': 'Already up to date',
        'currentVersion': currentVersion,
        'latestVersion': latestVersion,
      };
    }

    final url = (latestData['url'] ?? '').toString();
    final checksum = (latestData['checksum'] ?? '').toString();
    final releaseNotes = (latestData['releaseNotes'] ?? '').toString();

    if (url.isEmpty) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Download url missing',
      };
    }

    return _downloadAndInstall(
      url: url,
      checksum: checksum,
      version: latestVersion,
      fileName: 'libstudy.so',
      releaseNotes: releaseNotes,
    );
  }

  Future<Map<String, dynamic>> checkAndUpdateWindows({
    required Map<String, dynamic> currentVersionMap,
    required Map<String, dynamic> latestVersionMap,
  }) async {
    if (!Platform.isWindows) {
      return {
        'code': 200,
        'updated': false,
        'message': 'Skip update: not Windows',
      };
    }

    if (currentVersionMap['code'] != 200) {
      return {
        'code': currentVersionMap['code'] ?? 500,
        'updated': false,
        'message': 'Failed to read current version',
      };
    }

    if (latestVersionMap['code'] != 200) {
      return {
        'code': latestVersionMap['code'] ?? 500,
        'updated': false,
        'message': 'Failed to read latest version',
      };
    }

    final currentVersion = (currentVersionMap['data'] ?? '').toString();
    final latestData = latestVersionMap['data'];
    if (latestData is! Map) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Latest version data invalid',
      };
    }

    final latestVersion = (latestData['version'] ?? '').toString();
    if (currentVersion.isEmpty || latestVersion.isEmpty) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Version info missing',
      };
    }

    final compare = _compareVersions(currentVersion, latestVersion);
    if (compare >= 0) {
      return {
        'code': 200,
        'updated': false,
        'message': 'Already up to date',
        'currentVersion': currentVersion,
        'latestVersion': latestVersion,
      };
    }

    final url = (latestData['url'] ?? '').toString();
    final checksum = (latestData['checksum'] ?? '').toString();
    final releaseNotes = (latestData['releaseNotes'] ?? '').toString();

    if (url.isEmpty) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Download url missing',
      };
    }

    return _downloadAndInstall(
      url: url,
      checksum: checksum,
      version: latestVersion,
      fileName: 'libstudy.dll',
      releaseNotes: releaseNotes,
    );
  }

  Future<Map<String, dynamic>> checkAndUpdateLinux({
    required Map<String, dynamic> currentVersionMap,
    required Map<String, dynamic> latestVersionMap,
  }) async {
    if (!Platform.isLinux) {
      return {
        'code': 200,
        'updated': false,
        'message': 'Skip update: not Linux',
      };
    }

    if (currentVersionMap['code'] != 200) {
      return {
        'code': currentVersionMap['code'] ?? 500,
        'updated': false,
        'message': 'Failed to read current version',
      };
    }

    if (latestVersionMap['code'] != 200) {
      return {
        'code': latestVersionMap['code'] ?? 500,
        'updated': false,
        'message': 'Failed to read latest version',
      };
    }

    final currentVersion = (currentVersionMap['data'] ?? '').toString();
    final latestData = latestVersionMap['data'];
    if (latestData is! Map) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Latest version data invalid',
      };
    }

    final latestVersion = (latestData['version'] ?? '').toString();
    if (currentVersion.isEmpty || latestVersion.isEmpty) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Version info missing',
      };
    }

    final compare = _compareVersions(currentVersion, latestVersion);
    if (compare >= 0) {
      return {
        'code': 200,
        'updated': false,
        'message': 'Already up to date',
        'currentVersion': currentVersion,
        'latestVersion': latestVersion,
      };
    }

    final url = (latestData['url'] ?? '').toString();
    final checksum = (latestData['checksum'] ?? '').toString();
    final releaseNotes = (latestData['releaseNotes'] ?? '').toString();

    if (url.isEmpty) {
      return {
        'code': 500,
        'updated': false,
        'message': 'Download url missing',
      };
    }

    return _downloadAndInstall(
      url: url,
      checksum: checksum,
      version: latestVersion,
      fileName: 'libstudy.so',
      chmod: true,
      releaseNotes: releaseNotes,
    );
  }

  Future<Map<String, dynamic>> _downloadAndInstall({
    required String url,
    required String checksum,
    required String version,
    required String fileName,
    bool chmod = false,
    String? releaseNotes,
  }) async {
    Directory? tempDir;
    try {
      tempDir = await Directory.systemTemp.createTemp('libstudy_update_');
      final zipPath = p.join(tempDir.path, 'libstudy_$version.zip');
      await _downloadFile(url, zipPath);

      if (checksum.isNotEmpty) {
        final valid = await _verifyMd5(zipPath, checksum);
        if (!valid) {
          return {
            'code': 500,
            'updated': false,
            'message': 'Checksum mismatch',
            'version': version,
          };
        }
      }

      final libBytes = await _extractFile(zipPath, fileName);
      if (libBytes == null) {
        return {
          'code': 500,
          'updated': false,
          'message': '$fileName not found in archive',
          'version': version,
        };
      }

      final appDir = await getAppSupportDir();
      final targetPath = p.join(appDir, fileName);
      await File(targetPath).writeAsBytes(libBytes, flush: true);
      await File(p.join(appDir, 'libstudy.version'))
          .writeAsString(version, flush: true);

      if (chmod) {
        try {
          await Process.run('chmod', ['+x', targetPath]);
        } catch (e) {
          LoggerService().info('chmod failed for $targetPath', e);
        }
      }

      LoggerService().info('libstudy updated', {
        'path': targetPath,
        'version': version,
        'releaseNotes': releaseNotes,
      });

      return {
        'code': 200,
        'updated': true,
        'message': 'Updated successfully. Restart required.',
        'path': targetPath,
        'version': version,
        'releaseNotes': releaseNotes,
      };
    } catch (e) {
      LoggerService().error('Update failed', e);
      return {
        'code': 500,
        'updated': false,
        'message': 'Update failed: $e',
        'version': version,
      };
    } finally {
      if (tempDir != null) {
        try {
          await tempDir.delete(recursive: true);
        } catch (_) {}
      }
    }
  }

  Future<void> _downloadFile(String url, String savePath) async {
    final uri = Uri.parse(url);
    final client = HttpClient();
    try {
      final request = await client.getUrl(uri);
      final response = await request.close();
      if (response.statusCode != 200) {
        throw HttpException('Download failed with ${response.statusCode}');
      }

      final file = File(savePath);
      final sink = file.openWrite();
      await response.forEach(sink.add);
      await sink.flush();
      await sink.close();
    } finally {
      client.close();
    }
  }

  Future<bool> _verifyMd5(String filePath, String expected) async {
    final bytes = await File(filePath).readAsBytes();
    final digest = md5.convert(bytes).toString();
    return digest.toLowerCase() == expected.toLowerCase();
  }

  Future<List<int>?> _extractFile(String zipPath, String fileName) async {
    final bytes = await File(zipPath).readAsBytes();
    final archive = ZipDecoder().decodeBytes(bytes);
    for (final file in archive.files) {
      if (!file.isFile) continue;
      final name = p.basename(file.name);
      if (name == fileName) {
        return List<int>.from(file.content as List);
      }
    }
    return null;
  }

  int _compareVersions(String a, String b) {
    final aParts = _parseVersionParts(a);
    final bParts = _parseVersionParts(b);
    final maxLen =
        aParts.length > bParts.length ? aParts.length : bParts.length;
    for (var i = 0; i < maxLen; i++) {
      final aVal = i < aParts.length ? aParts[i] : 0;
      final bVal = i < bParts.length ? bParts[i] : 0;
      if (aVal > bVal) return 1;
      if (aVal < bVal) return -1;
    }
    return 0;
  }

  List<int> _parseVersionParts(String version) {
    return version
        .split('.')
        .map((part) => int.tryParse(_digitsOnly(part)) ?? 0)
        .toList();
  }

  String _digitsOnly(String input) {
    final match = RegExp(r'\d+').firstMatch(input);
    return match?.group(0) ?? '0';
  }
}
