package com.example.adithia_3tie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.adithia_3tie.Home.HomeFragment
import com.example.adithia_3tie.Message.MessageFragment
import com.example.adithia_3tie.More.MoreFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BaseActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        // Inisialisasi Toolbar & BottomNavigationView
        toolbar = findViewById(R.id.toolbar)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        setSupportActionBar(toolbar)

        // Inisialisasi Fragments
        val homeFragment = HomeFragment()
        val messageFragment = MessageFragment()
        val moreFragment = MoreFragment()

        // Set Tampilan Awal
        setCurrentFragment(homeFragment, "Home")

        // Listener menu bawah (disesuaikan dengan modul)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> setCurrentFragment(homeFragment, "Home")
                R.id.message -> setCurrentFragment(messageFragment, "Message")
                R.id.more -> setCurrentFragment(moreFragment, "Message")
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment, title: String) {
        toolbar.title = title
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }
}