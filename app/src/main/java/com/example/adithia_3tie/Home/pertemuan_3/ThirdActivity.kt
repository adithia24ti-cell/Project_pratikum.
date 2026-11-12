package com.example.adithia_3tie.Home.pertemuan_3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adithia_3tie.R
import com.example.adithia_3tie.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    // ViewBinding: nama kelas menyesuaikan nama layout (activity_third.xml -> ActivityThirdBinding)
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("onCreate", "ThirdActivity dibuat pertama kali")

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Pertemuan 5: Toolbar beserta tombol back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Activity Third"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Intent: berpindah ke ThirdResultActivity saat klik btnKirim
        binding.btnKirim.setOnClickListener {
            val noTujuan = binding.inputNoTujuan.text
            Log.e("Klik btnKirim", "Nomor tujuan = $noTujuan")

            val intent = Intent(this, ThirdResultActivity::class.java)
            startActivity(intent)
        }
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
        Log.e("onStart", "onStart: ThirdActivity terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "ThirdActivity dihapus dari stack")
    }
}
