package com.flimflo.alpha.ui.news

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.flimflo.alpha.database.Constants

@Dao
interface NewsDao {
    @Query("SELECT * FROM " + Constants.TABLE_NAME_NEWS)
    fun GetAll(): MutableList<News>

    @Query("DELETE FROM " + Constants.TABLE_NAME_GAMES)
    fun DeleteAll()

    @Insert
    fun InsertList(newsList: MutableList<News>)
}