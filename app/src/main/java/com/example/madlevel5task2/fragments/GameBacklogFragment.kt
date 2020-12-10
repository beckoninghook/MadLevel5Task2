package com.example.madlevel5task2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.model.GameViewModel
import java.util.Observer

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameBacklogFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        btnSave.setOnClickListener {
//            saveNote()
//        }
//
//        observeNote()

    }

    private fun observeNote() {
//fill the text fields with the current text and title from the viewmodel
//        viewModel.game.observe(viewLifecycleOwner, Observer {
//                game  ->
//            game?.let {
//                tilNoteTitle.editText?.setText(it.title)
//                tilNoteText.editText?.setText(it.text)
//            }
//
//        })
//
//        viewModel.error.observe(viewLifecycleOwner, Observer { message ->
//            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
//        })
//
//        viewModel.success.observe(viewLifecycleOwner, Observer {     success ->
//            //"pop" the backstack, this means we destroy this    fragment and go back to the RemindersFragment
//            findNavController().popBackStack()
//        })
    }

//    private fun saveNote() {
//        viewModel.updateNote(tilNoteTitle.editText?.text.toString(), tilNoteText.editText?.text.toString())
//    }
}