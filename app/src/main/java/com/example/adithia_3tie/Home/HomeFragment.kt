package com.example.adithia_3tie.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.adithia_3tie.R
import com.example.adithia_3tie.Pertemuan2.MainActivity
import com.example.adithia_3tie.Pertemuan3.LoginActivity
import com.example.adithia_3tie.pertemuan4.FourthActivity
import com.example.adithia_3tie.Pertemuan5.FifthActivity
import com.example.adithia_3tie.Pertemuan6.AuthActivity

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val b2 = view.findViewById<Button>(R.id.btnPertemuan2)
        val b3 = view.findViewById<Button>(R.id.btnPertemuan3)
        val b4 = view.findViewById<Button>(R.id.btnPertemuan4)
        val b5 = view.findViewById<Button>(R.id.btnPertemuan5)
        val b6 = view.findViewById<Button>(R.id.btnPertemuan6)

        b2?.setOnClickListener {
            startActivity(Intent(requireActivity(), MainActivity::class.java))
        }

        b3?.setOnClickListener {
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
        }

        b4?.setOnClickListener {
            startActivity(Intent(requireActivity(), FourthActivity::class.java))
        }

        b5?.setOnClickListener {
            startActivity(Intent(requireActivity(), FifthActivity::class.java))
        }

        b6?.setOnClickListener {
            startActivity(Intent(requireActivity(), AuthActivity::class.java))
        }
    }
}