import 'package:connectivity_plus/connectivity_plus.dart';

class ConnectivityService {
  static final ConnectivityService _instance = ConnectivityService._internal();

  final Connectivity _connectivity = Connectivity();
  bool _isConnected = true;
  List<Function(bool)> _listeners = [];

  factory ConnectivityService() {
    return _instance;
  }

  ConnectivityService._internal();

  Future<void> initialize() async {
    // Check initial connectivity status
    await _checkConnectivity();

    // Listen to connectivity changes
    _connectivity.onConnectivityChanged.listen((result) async {
      final wasConnected = _isConnected;

      // Handle both single result and list of results
      if (result is List) {
        _isConnected = (result as List).isNotEmpty &&
            !(result as List).contains(ConnectivityResult.none);
      } else {
        _isConnected = result != ConnectivityResult.none;
      }

      // Notify listeners if status changed
      if (wasConnected != _isConnected) {
        _notifyListeners();
      }
    });
  }

  Future<void> _checkConnectivity() async {
    try {
      final result = await _connectivity.checkConnectivity();
      final wasConnected = _isConnected;

      // ConnectivityResult.none means no connection
      _isConnected = result != ConnectivityResult.none;

      // Notify listeners if status changed
      if (wasConnected != _isConnected) {
        _notifyListeners();
      }
    } catch (e) {
      print('Error checking connectivity: $e');
    }
  }

  bool get isConnected => _isConnected;

  void addListener(Function(bool) listener) {
    _listeners.add(listener);
  }

  void removeListener(Function(bool) listener) {
    _listeners.remove(listener);
  }

  void _notifyListeners() {
    for (var listener in _listeners) {
      listener(_isConnected);
    }
  }

  void dispose() {
    _listeners.clear();
  }
}
