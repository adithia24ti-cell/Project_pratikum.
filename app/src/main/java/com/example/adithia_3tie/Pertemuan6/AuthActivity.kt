package com.example.adithia_3tie.Pertemuan6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adithia_3tie.MainActivity
import com.example.adithia_3tie.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // =========================================================
        // 1. INSIALISASI SHAREDPREFERENCES & PENGECEKAN STATUS LOGIN
        // =========================================================
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE) //
        val isLogin = sharedPref.getBoolean("isLogin", false) //[cite: 18]

        // Jika user sudah login sebelumnya, langsung arahkan ke MainActivity
        if (isLogin) { //[cite: 17, 18]
            val intent = Intent(this, MainActivity::class.java) //[cite: 18]
            startActivity(intent) //[cite: 18]
            finish()
            return
        }

        // 2. Inisialisasi Komponen Layout
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // 3. Action Listener untuk Tombol Login
        btnLogin.setOnClickListener { //[cite: 18]
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Cek apakah username = password dan tidak kosong
            if (username.isNotEmpty() && username == password) {

                // =========================================================
                // SIMPAN STATUS LOGIN KE SHAREDPREFERENCES
                // =========================================================
                val editor = sharedPref.edit() //[cite: 16, 19]
                editor.putBoolean("isLogin", true) //[cite: 16, 17, 19]
                editor.putString("username", username) //[cite: 16, 19]
                editor.apply() //

                // Pindah ke MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Tampilkan AlertDialog jika gagal
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .show()
            }
        }
    }
}