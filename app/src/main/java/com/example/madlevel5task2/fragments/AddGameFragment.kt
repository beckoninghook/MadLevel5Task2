package com.example.madlevel5task2.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.model.Game
import com.example.madlevel5task2.model.GameViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_add_game.*
import kotlinx.android.synthetic.main.game_card.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AddGameFragment : Fragment() {
    private val viewModel: GameViewModel by viewModels()

    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FloatingActionButton>(R.id.fabSaveGame).setOnClickListener {
            saveGame()
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }


    @SuppressLint("SimpleDateFormat")
    private fun saveGame() {



        val sdf = SimpleDateFormat("yyyy-MM-dd")
        var dateString = "$inputDay-$inputMonth-$inputYear"
        try {
            viewModel.insertGame(Game(tvTitle.toString() ,  sdf.parse(dateString) , tvGamePlatforms.toString() ) )
        } catch (e: ParseException) {
            error.value = "Please enter a valid date."
        }

    }


}