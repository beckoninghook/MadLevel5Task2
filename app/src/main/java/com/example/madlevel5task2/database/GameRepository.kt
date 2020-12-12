package com.example.madlevel5task2.database


import android.content.Context
import androidx.lifecycle.LiveData
import com.example.madlevel5task2.model.Game


class GameRepository(context: Context) {
    private val gameDao: GameDao


    init {
        val database = GameBacklogDatabase.getDatabase(context)
        gameDao =  database!!.gameDao()
    }

    fun getGameBacklog(): LiveData<Game?> {
        return gameDao.getGames()
    }


    suspend fun updateBacklog(game: Game) {
        gameDao.updateGame(game)
    }

    suspend fun insertGame(game: Game ) {
        gameDao?.insertGame(game);
    }
}
