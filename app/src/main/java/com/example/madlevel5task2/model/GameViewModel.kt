package com.example.madlevel5task2.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.database.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.sql.Date
import java.util.*

class GameViewModel (application: Application) : AndroidViewModel(application) {

    private val gameRepository =
        GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val game = gameRepository.getGameBacklog()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()

    val games: LiveData<List<Game>> = gameRepository.getAllGames()

    private val ioScope = CoroutineScope(Dispatchers.IO)


    fun insertGame(game: Game) {
        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }

    fun deleteAll() {
        ioScope.launch {
            gameRepository.deleteAll()
        }
    }

}
