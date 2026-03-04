import 'dart:convert';
import 'dart:io';
import 'package:logger/logger.dart';
import 'package:path_provider/path_provider.dart';

class LoggerService {
  static final LoggerService _instance = LoggerService._internal();
  Logger? _logger;
  String? _logFilePath;
  File? _logFile;

  static const String _primaryLogFileName = 'AroApp.log';
  static const String _secondaryLogFileName = 'AroApp.1.log';

  LoggerService._internal();

  factory LoggerService() {
    return _instance;
  }

  Future<void> initialize({
    int maxFileSizeBytes = 10 * 1024 * 1024,
    int maxLogFiles = 2,
  }) async {
    try {
      final appDir = await getApplicationSupportDirectory();
      final logDir = Directory('${appDir.path}/logs');

      if (!await logDir.exists()) {
        await logDir.create(recursive: true);
      }

      final primaryPath = '${logDir.path}/$_primaryLogFileName';
      final secondaryPath = '${logDir.path}/$_secondaryLogFileName';

      _logFilePath = primaryPath;
      _logFile = File(primaryPath);
      await _logFile!.create(recursive: true);

      _logger = Logger(
        filter: ProductionFilter(),
        printer: PrettyPrinter(
          methodCount: 2,
          errorMethodCount: 8,
          lineLength: 120,
          colors: false,
          printEmojis: false,
        ),
        output: _FileOutput(
          primaryFile: _logFile!,
          secondaryFile: File(secondaryPath),
          maxFileSizeBytes: maxFileSizeBytes,
          useSecondaryFile: maxLogFiles >= 2,
        ),
      );

      print('Logger initialized on ${_getPlatformName()}');
      print('Log file: $_logFilePath');
      if (maxLogFiles >= 2) {
        print('Secondary log file: $secondaryPath');
      }
      _logger?.i(
        'Logger initialized. Log file: $_logFilePath (secondary: $secondaryPath)',
      );
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

  String get logFilePath => _logFilePath ?? 'Not initialized';

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
    final timestamp = DateTime.now().toString();
    final messageWithTime = '[$timestamp] $message';
    if (_logger != null) {
      _logger!.i(messageWithTime, error: error, stackTrace: stackTrace);
    } else {
      print('[INFO] $messageWithTime');
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
    final timestamp = DateTime.now().toString();
    final messageWithTime = '[$timestamp] $message';
    final logger = _logger;
    if (logger != null) {
      logger.e(messageWithTime, error: error, stackTrace: stackTrace);
      return;
    }

    print('[ERROR] $messageWithTime');
    if (error != null) print(error);
    if (stackTrace != null) print(stackTrace);
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
  final File _primaryFile;
  final File _secondaryFile;
  final int maxFileSizeBytes;
  final bool useSecondaryFile;

  File _activeFile;

  _FileOutput({
    required File primaryFile,
    required File secondaryFile,
    required this.maxFileSizeBytes,
    this.useSecondaryFile = true,
  })  : _primaryFile = primaryFile,
        _secondaryFile = secondaryFile,
        _activeFile = primaryFile {
    _activeFile = _selectInitialActiveFile();
  }

  File _selectInitialActiveFile() {
    if (!useSecondaryFile) return _primaryFile;

    try {
      final primaryExists = _primaryFile.existsSync();
      final secondaryExists = _secondaryFile.existsSync();

      if (!primaryExists && !secondaryExists) return _primaryFile;
      if (!primaryExists && secondaryExists) return _secondaryFile;
      if (primaryExists && !secondaryExists) return _primaryFile;

      final primaryModified = _primaryFile.statSync().modified;
      final secondaryModified = _secondaryFile.statSync().modified;

      return secondaryModified.isAfter(primaryModified)
          ? _secondaryFile
          : _primaryFile;
    } catch (_) {
      return _primaryFile;
    }
  }

  void _ensureParentDirExists(File file) {
    final parent = file.parent;
    if (parent.existsSync()) return;
    parent.createSync(recursive: true);
  }

  void _ensureFileExists(File file) {
    _ensureParentDirExists(file);
    if (file.existsSync()) return;
    file.createSync(recursive: true);
  }

  void _truncateFile(File file) {
    _ensureParentDirExists(file);
    file.writeAsBytesSync(const [], mode: FileMode.write);
  }

  File _otherFile() {
    if (!useSecondaryFile) return _primaryFile;
    return identical(_activeFile, _primaryFile) ? _secondaryFile : _primaryFile;
  }

  void _rotateToOtherFile() {
    try {
      final nextFile = _otherFile();
      _ensureFileExists(nextFile);

      // Start fresh each time we switch, so each file is bounded by maxFileSizeBytes.
      _truncateFile(nextFile);
      _activeFile = nextFile;
    } catch (_) {
      // Ignore rotation failures.
    }
  }

  void _maybeRotate(int additionalBytes) {
    if (maxFileSizeBytes <= 0) return;

    try {
      _ensureFileExists(_activeFile);

      final currentBytes = _activeFile.lengthSync();
      if (currentBytes + additionalBytes <= maxFileSizeBytes) return;

      if (!useSecondaryFile) {
        _truncateFile(_activeFile);
        return;
      }

      _rotateToOtherFile();
    } catch (_) {
      // Ignore rotation failures.
    }
  }

  @override
  void output(OutputEvent event) {
    for (var line in event.lines) {
      final data = '$line\n';
      _maybeRotate(utf8.encode(data).length);
      _activeFile.writeAsStringSync(data, mode: FileMode.append);
    }
  }
}
