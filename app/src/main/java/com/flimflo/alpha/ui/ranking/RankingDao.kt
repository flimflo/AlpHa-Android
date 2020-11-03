package com.flimflo.alpha.ui.ranking

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.flimflo.alpha.database.Constants
import com.flimflo.alpha.ui.news.News

@Dao
interface RankingDao {
    @Query("SELECT * FROM " + Constants.TABLE_NAME_RANKING)
    fun GetAll(): MutableList<Ranking>

    @Query("DELETE FROM " + Constants.TABLE_NAME_RANKING)
    fun DeleteAll()

    @Insert
    fun InsertList(newsList: MutableList<Ranking>)
}