package com.flimflo.alpha.ui.games

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.flimflo.alpha.database.Constants

@Dao
interface GamesDao {
    @Query("SELECT * FROM " + Constants.TABLE_NAME_GAMES)
    fun GetAll(): MutableList<Games>

    @Query("DELETE FROM " + Constants.TABLE_NAME_GAMES)
    fun DeleteAll()

    @Insert
    fun InsertList(gamesList: MutableList<Games>)
}