package com.example.adithia_3tie.Pertemuan6

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.adithia_3tie.MainActivity
import com.example.adithia_3tie.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Jalankan delay 2 detik (2000 ms) lalu cek session login
        lifecycleScope.launch {
            delay(2000)

            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            if (isLogin) {
                // Jika isLogin true -> pindah ke MainActivity
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Jika isLogin false -> pindah ke AuthActivity
                val intent = Intent(this@SplashScreenActivity, AuthActivity::class.java)
                startActivity(intent)
            }
            finish()
        }
    }
}