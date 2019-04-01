package com.smartflowlite_webview

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var appTAG = "SmartFlow Lite"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Log.e(appTAG, "Application up and running")
        checkPermissions()


        val demoWebView :WebView    =   findViewById(R.id.sfwebView)

        demoWebView.webViewClient   =   WebViewClient()                 //Allowing page navigation and disable new page

        Thread.sleep(2000)

        demoWebView.loadUrl("http://192.168.123.171/sflite/logon.aspx")
        demoWebView.settings.javaScriptEnabled = true

        demoWebView.clearCache(true)
        demoWebView.settings.allowFileAccess      =   true
        demoWebView.settings.databaseEnabled      =   true
        demoWebView.settings.allowContentAccess   =   true
    }

    fun checkPermissions() {
        val toastMessageGranted = "Permissions Granted"
        val toastMessageDenied = "Permissions Denied"

        Log.e(appTAG, "checkPermissions function")

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED)
        {
                Log.e(appTAG, toastMessageGranted)
                Toast.makeText(this, toastMessageGranted, Toast.LENGTH_LONG).show()

        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_DENIED)
        {
                Log.e(appTAG, toastMessageDenied)
                Toast.makeText(this, toastMessageDenied, Toast.LENGTH_LONG).show()
        }
    }
}