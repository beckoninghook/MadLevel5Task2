package com.example.madlevel5task2.fragments

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.example.madlevel5task2.R
import com.example.madlevel5task2.model.Game
import com.example.madlevel5task2.model.GameViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_game.*
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

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val snackbar = Snackbar.make(view, "",
            Snackbar.LENGTH_SHORT)



        view.findViewById<FloatingActionButton>(R.id.fabSaveGame).setOnClickListener {
            if (isFormValid(snackbar)){
                println("form is valid")
                saveGame()
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }else {

            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true);
        activity?.title = "Add game"

        (activity as AppCompatActivity?)!!.supportActionBar?.setDisplayHomeAsUpEnabled(true);
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SimpleDateFormat")
    private fun isFormValid(snackbar: Snackbar): Boolean {

        return if(tvTitle.text.isEmpty() || tvTitle.text.toString() === ""){
            snackbar.setText("Title is not valid")
            snackbar.show()
            false
        } else if (inputPlatform.text.isEmpty() || inputPlatform.text.toString() === ""){
            snackbar.setText("Platform is not valid")
            snackbar.show()
            false
        }else if (dateCheck()){
            snackbar.setText("Date is not valid")
            snackbar.show()
            false
        }else {
            true
        }



    }

    private fun dateCheck() : Boolean{
        val day = inputDay.text
        val month = inputMonth.text
        val year = inputYear.text
        val dateString = "$day-$month-$year"

        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return try {
            sdf.parse(dateString)
            true;
        }catch (e : ParseException){
            false
        }

    }

    @SuppressLint("SimpleDateFormat")
    private fun saveGame(){
        val day = inputDay.text
        val month = inputMonth.text
        val year = inputYear.text
        val dateString = "$day-$month-$year"

        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val date : Date? =   sdf.parse(dateString);

        viewModel.insertGame(Game(tvTitle.text.toString() ,
            date  , inputPlatform.text.toString() ) )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.menu_main, menu)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onOptionsItemSelected(item: MenuItem  ): Boolean {

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)

        return true;
    }

}