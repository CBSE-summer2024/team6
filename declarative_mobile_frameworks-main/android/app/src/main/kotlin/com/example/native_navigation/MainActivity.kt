package com.example.native_navigation

import android.content.Intent
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity : FlutterFragmentActivity() {
    private val events = "com.hendrick.navigateChannel"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            events
        ).setMethodCallHandler { call, result ->
            if (call.method == "navigateFunction") {
                val intent = Intent(this, ComposeActivity::class.java)
                startActivity(intent)
                result.success("Navigated to Kotlin page")
            } else {
                result.notImplemented()
            }
        }
    }
}
