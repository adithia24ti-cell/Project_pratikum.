@file:Suppress("PackageName")

package com.example.adithia_3tie.Pertemuan5

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.adithia_3tie.R
import com.google.android.material.appbar.AppBarLayout

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var appBar: AppBarLayout
    private lateinit var toolbar: Toolbar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        // 1. Inisialisasi View
        appBar = findViewById(R.id.appBar)
        toolbar = findViewById(R.id.toolbar)
        webView = findViewById(R.id.webView)

        // 2. Toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            title = "Web Merdeka"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        // 3. Client & Settings WebView
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true

            // Tambahan agar tampilan responsive merdeka.com menyesuaikan ukuran layar Medium Phone
            useWideViewPort = true
            loadWithOverviewMode = true
            databaseEnabled = true
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        // 4. Load URL Merdeka
        webView.loadUrl("https://www.merdeka.com")

        // 5. Scroll Toolbar Animation
        webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                appBar.setExpanded(false, true)
            } else if (scrollY < oldScrollY) {
                appBar.setExpanded(true, true)
            }
        }

        // 6. Handling Tombol Back HP
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (::webView.isInitialized && webView.canGoBack()) {
                    webView.goBack()
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed()
                }
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}