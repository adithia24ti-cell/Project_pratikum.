@file:Suppress("PackageName")

package com.example.adithia_3tie.Note

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adithia_3tie.Data.AppDatabase
import com.example.adithia_3tie.Data.entity.NoteEntity
import com.example.adithia_3tie.databinding.FragmentNoteBinding
import kotlinx.coroutines.launch

class NoteFragment : Fragment() {

    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    /** Variabel database & Adapter **/
    private lateinit var adapter: NoteAdapter
    private lateinit var db: AppDatabase
    private val notes = mutableListOf<NoteEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Note"
        }

        /** Inisialisasi AppDatabase & Adapter **/
        db = AppDatabase.getInstance(requireContext())
        adapter = NoteAdapter(notes, this)

        binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotes.adapter = adapter

        /** Tambah ini sebagai garis pemisah **/
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.rvNotes.addItemDecoration(dividerItemDecoration)

        fetchNotes()

        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFormActivity::class.java))
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchNotes() {
        lifecycleScope.launch {
            val data = db.noteDao().getAll()
            notes.clear()
            notes.addAll(data)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onResume() {
        super.onResume()
        fetchNotes()
    }

    fun deleteNote(note: NoteEntity) {
        lifecycleScope.launch {
            db.noteDao().delete(note)
            fetchNotes()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}