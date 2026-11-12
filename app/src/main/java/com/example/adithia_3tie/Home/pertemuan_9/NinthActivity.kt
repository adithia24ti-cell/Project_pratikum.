package com.example.adithia_3tie.Home.pertemuan_9

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adithia_3tie.R
import com.example.adithia_3tie.databinding.ActivityNinthBinding
import com.google.android.material.chip.Chip

class NinthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNinthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityNinthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Toolbar beserta tombol back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Activity Ninth"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

        // Chip & ChipGroup: mendeteksi Chip mana yang dipilih
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull() // Ambil ID chip yang dipilih

            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(this, "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
                // Lakukan logika filter di sini
            }
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
}
