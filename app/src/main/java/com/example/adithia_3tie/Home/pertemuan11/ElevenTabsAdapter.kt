@file:Suppress("PackageName", "SpellCheckingInspection")

package com.example.adithia_3tie.Home.pertemuan11

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ElevenTabsAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    // Total number of tabs
    override fun getItemCount(): Int = 3

    // Determine which Fragment to display based on tab position
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabAFragment()
            1 -> TabBFragment()
            2 -> TabCFragment()
            else -> throw IllegalStateException("Invalid tab position")
        }
    }
}