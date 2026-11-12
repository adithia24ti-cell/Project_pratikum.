package com.example.adithia_3tie.Home.pertemuan_5

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.adithia_3tie.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengaktifkan toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Web Merdeka"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl("https://merdeka.com")

        // Agar Toolbar hide/show saat scroll web
        binding.webView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            if (scrollY > oldScrollY) {
                binding.appBar.setExpanded(false, true) // sembunyikan
            } else if (scrollY < oldScrollY) {
                binding.appBar.setExpanded(true, true) // tampilkan
            }
        }

        // PERBAIKAN: modul memakai "override fun onBackPressed()" yang sudah deprecated dan
        // tidak dipanggil lagi pada Android versi baru. Diganti OnBackPressedCallback
        // dengan logika yang sama (kembali ke halaman web sebelumnya, jika tidak ada keluar Activity).
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack() // Kembali ke halaman web sebelumnya
                } else {
                    isEnabled = false
                    onBackPressedDispatcher.onBackPressed() // Keluar dari Activity
                }
            }
        })
    }

    // Mengaktifkan tombol back pada toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
