package com.example.adithia_3tie.Home.pertemuan_6

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.example.adithia_3tie.BaseActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
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

        lifecycleScope.launch {
            delay(2000) // simulasi pengambilan data selama 2 detik

            // Pengecekan isLogin dilakukan di SplashScreen
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val isLogin = sharedPref.getBoolean("isLogin", false)

            if (isLogin) {
                // isLogin true -> BaseActivity
                startActivity(Intent(this@SplashScreenActivity, BaseActivity::class.java))
            } else {
                // isLogin false -> AuthActivity
                startActivity(Intent(this@SplashScreenActivity, AuthActivity::class.java))
            }
            finish()
        }
    }
}
