import 'dart:io';
import 'package:logger/logger.dart';
import 'package:path_provider/path_provider.dart';

class LoggerService {
  static final LoggerService _instance = LoggerService._internal();
  Logger? _logger;
  late File _logFile;
  late String _logFilePath;

  LoggerService._internal();

  factory LoggerService() {
    return _instance;
  }

  Future<void> initialize() async {
    try {
      final appDir = await getApplicationSupportDirectory();
      final logDir = Directory('${appDir.path}/logs');

      if (!await logDir.exists()) {
        await logDir.create(recursive: true);
      }

      final timestamp =
          DateTime.now().toString().replaceAll(':', '-').split('.')[0];
      _logFilePath = '${logDir.path}/app_$timestamp.log';
      _logFile = File(_logFilePath);

      await _logFile.create(recursive: true);

      _logger = Logger(
        filter: ProductionFilter(),
        printer: PrettyPrinter(
          methodCount: 2,
          errorMethodCount: 8,
          lineLength: 120,
          colors: false,
          printEmojis: false,
        ),
        output: _FileOutput(_logFile),
      );

      print('Logger initialized on ${_getPlatformName()}');
      print('Log file: $_logFilePath');
      _logger?.i('Logger initialized. Log file: $_logFilePath');
    } catch (e) {
      print('Failed to initialize logger: $e');
      print('Platform: ${_getPlatformName()}');
      rethrow;
    }
  }

  static String _getPlatformName() {
    if (Platform.isWindows) return 'Windows';
    if (Platform.isMacOS) return 'macOS';
    if (Platform.isLinux) return 'Linux';
    if (Platform.isAndroid) return 'Android';
    if (Platform.isIOS) return 'iOS';
    return 'Unknown';
  }

  String get logFilePath => _logFilePath;

  Future<String> getLogDirectory() async {
    final appDir = await getApplicationSupportDirectory();
    return '${appDir.path}/logs';
  }

  void debug(String message, [dynamic error, StackTrace? stackTrace]) {
    if (_logger != null) {
      _logger!.d(message, error: error, stackTrace: stackTrace);
    } else {
      print('[DEBUG] $message');
      if (error != null) print(error);
      if (stackTrace != null) print(stackTrace);
    }
  }

  void info(String message, [dynamic error, StackTrace? stackTrace]) {
    if (_logger != null) {
      _logger!.i(message, error: error, stackTrace: stackTrace);
    } else {
      print('[INFO] $message');
    }
  }

  void warning(String message, [dynamic error, StackTrace? stackTrace]) {
    if (_logger != null) {
      _logger!.w(message, error: error, stackTrace: stackTrace);
    } else {
      print('[WARN] $message');
      if (error != null) print(error);
    }
  }

  void error(String message, [dynamic error, StackTrace? stackTrace]) {
    if (_logger != null) {
      _logger!.e(message, error: error, stackTrace: stackTrace);
    } else {
      print('[ERROR] $message');
      if (error != null) print(error);
      if (stackTrace != null) print(stackTrace);
    }
  }

  Future<void> cleanOldLogs({int daysToKeep = 7}) async {
    try {
      final logDir = Directory(await getLogDirectory());
      if (!await logDir.exists()) return;

      final now = DateTime.now();
      final files = logDir.listSync();

      for (var file in files) {
        if (file is File && file.path.endsWith('.log')) {
          final stat = file.statSync();
          final fileDate = stat.modified;
          final difference = now.difference(fileDate).inDays;

          if (difference > daysToKeep) {
            await file.delete();
            _logger?.i('Deleted old log file: ${file.path}');
          }
        }
      }
    } catch (e) {
      _logger?.e('Error cleaning old logs', error: e);
    }
  }
}

class _FileOutput extends LogOutput {
  final File file;

  _FileOutput(this.file);

  @override
  void output(OutputEvent event) {
    for (var line in event.lines) {
      file.writeAsStringSync('$line\n', mode: FileMode.append);
    }
  }
}
