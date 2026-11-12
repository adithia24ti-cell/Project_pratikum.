@file:Suppress("PackageName", "SpellCheckingInspection")

package com.example.adithia_3tie.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.example.adithia_3tie.Home.pertemuan11.ElevenActivity
import com.example.adithia_3tie.Home.pertemuan_10.TenthActivity
import com.example.adithia_3tie.Home.pertemuan_2.SecondActivity
import com.example.adithia_3tie.Home.pertemuan_3.ThirdActivity
import com.example.adithia_3tie.Home.pertemuan_4.FourthActivity
import com.example.adithia_3tie.Home.pertemuan_5.FifthActivity
import com.example.adithia_3tie.Home.pertemuan_6.AuthActivity
import com.example.adithia_3tie.Home.pertemuan_6.SixthActivity
import com.example.adithia_3tie.Home.pertemuan_7.SeventhActivity
import com.example.adithia_3tie.Home.pertemuan_9.NinthActivity
import com.example.adithia_3tie.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        // Pertemuan 2
        binding.btnToSecond.setOnClickListener {
            startActivity(Intent(requireContext(), SecondActivity::class.java))
        }

        // Pertemuan 3
        binding.btnToThird.setOnClickListener {
            startActivity(Intent(requireContext(), ThirdActivity::class.java))
        }

        // Pertemuan 4
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        // Pertemuan 5
        binding.btnToFifth.setOnClickListener {
            startActivity(Intent(requireContext(), FifthActivity::class.java))
        }

        // Pertemuan 6
        binding.btnToSixth.setOnClickListener {
            startActivity(Intent(requireContext(), SixthActivity::class.java))
        }

        // Pertemuan 7
        binding.btnToSeventh.setOnClickListener {
            startActivity(Intent(requireContext(), SeventhActivity::class.java))
        }

        // Pertemuan 9
        binding.btnToNinth.setOnClickListener {
            startActivity(Intent(requireContext(), NinthActivity::class.java))
        }

        // Pertemuan 10
        binding.btnToTenth.setOnClickListener {
            startActivity(Intent(requireContext(), TenthActivity::class.java))
        }

        // Pertemuan 11
        binding.btnToEleven.setOnClickListener {
            startActivity(Intent(requireContext(), ElevenActivity::class.java))
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Konfirmasi Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    val sharedPref = requireContext().getSharedPreferences("user_pref", AppCompatActivity.MODE_PRIVATE)
                    sharedPref.edit {
                        clear()
                    }

                    startActivity(Intent(requireContext(), AuthActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}