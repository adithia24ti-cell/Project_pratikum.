@file:Suppress("PackageName", "SpellCheckingInspection")

package com.example.adithia_3tie.Home.pertemuan11

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adithia_3tie.R
import com.example.adithia_3tie.databinding.ActivityElevenBinding
import com.google.android.material.tabs.TabLayoutMediator

class ElevenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityElevenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityElevenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Setup Toolbar & Tombol Back
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // 1. Inisialisasi Adapter
        val tabsAdapter = ElevenTabsAdapter(this)

        // 2. Set adapter ke ViewPager2
        binding.viewPager.adapter = tabsAdapter

        // 3. Hubungkan TabLayout & ViewPager2 + Customize Icon & Badge
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab A"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                }
                1 -> {
                    tab.text = "Tab B"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 5
                }
                2 -> {
                    tab.text = "Tab C"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
                    val badge = tab.getOrCreateBadge()
                    badge.isVisible = true
                    badge.number = 12
                }
            }
        }.attach()
    }
}