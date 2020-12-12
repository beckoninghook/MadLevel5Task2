package com.example.madlevel5task2.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.madlevel5task2.database.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class GameViewModel (application: Application) : AndroidViewModel(application) {

    private val gameRepository =
        GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val game = gameRepository.getGameBacklog()
    val error = MutableLiveData<String>()
    val success = MutableLiveData<Boolean>()


    private val ioScope = CoroutineScope(Dispatchers.IO)


    fun updateGame(title: String, platform : String , date: Date) {

        //if there is an existing note, take that id to update it instead of adding a new one
        val newGame = Game(
            id = game.value?.id,
            title = title,
            release = Date(),
            platform = platform
        )

            mainScope.launch {
                withContext(Dispatchers.IO) {
                    gameRepository.updateBacklog(newGame)
                }
                success.value = true
            }

    }

    fun insertGame(game: Game) {
        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }

}
