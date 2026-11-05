package com.example.adithia_3tie

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.adithia_3tie.Home.FragmentHome
import com.example.adithia_3tie.Message.FragmentMessage
import com.example.adithia_3tie.More.FragmentMore
import com.example.adithia_3tie.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // systemBars.bottom diubah menjadi 0 agar BottomNavigation tidak memiliki jarak di bagian bawah
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        /** FragmentHome sebagai fragment default */
        if (savedInstanceState == null) {
            replaceFragment(FragmentHome())
        }

        binding.bottomNavView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceFragment(FragmentHome())
                    true
                }
                R.id.message -> {
                    replaceFragment(FragmentMessage())
                    true
                }
                R.id.more -> {
                    replaceFragment(FragmentMore())
                    true
                }
                else -> false // return false jika item tidak ada yang di klik
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            //.addToBackStack(null) -> dinonaktifkan agar saat back langsung keluar aplikasi
            .commit()
    }
}
