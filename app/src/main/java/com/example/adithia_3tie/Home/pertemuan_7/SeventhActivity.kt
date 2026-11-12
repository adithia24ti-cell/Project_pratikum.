package com.example.adithia_3tie.Home.pertemuan_7

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.adithia_3tie.R
import com.example.adithia_3tie.databinding.ActivitySeventhBinding

// PERBAIKAN: di modul Activity ini disebut "SixthActivity" / activity_sixth.xml / pertemuan_6,
// padahal pada langkah awal dibuat sebagai SeventhActivity di pertemuan_7. Disamakan menjadi SeventhActivity.
class SeventhActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySeventhBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySeventhBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "SeventhActivity dibuat pertama kali")

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toolbar beserta tombol back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Activity Seventh"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Menampilkan fragment pertama secara default
        replaceFragment(SatuFragment())

        // Setup event click untuk mengganti fragment
        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    // Mengganti fragment di dalam fragment_container
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null) // memungkinkan pengguna kembali ke fragment sebelumnya dengan tombol back
            .commit()
    }

    // Agar tombol back pada Toolbar berfungsi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: SeventhActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "SeventhActivity dihapus dari stack")
    }
}
