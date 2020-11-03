package com.flimflo.alpha.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.flimflo.alpha.ui.games.Games
import com.flimflo.alpha.ui.games.GamesDao
import com.flimflo.alpha.ui.news.News
import com.flimflo.alpha.ui.news.NewsDao
import com.flimflo.alpha.ui.ranking.Ranking
import com.flimflo.alpha.ui.ranking.RankingDao

@Database(entities = [News::class, Games::class, Ranking::class], version = 1)
@TypeConverters(DataRoomConverter::class)
abstract class AlphaDataBase : RoomDatabase() {
    abstract val newsDao: NewsDao
    abstract val gamesDao: GamesDao
    abstract val rankingDao : RankingDao

    companion object {
        @Volatile
        private var INSTANCE: AlphaDataBase? = null

        fun getInstance(context: Context): AlphaDataBase {
            if (INSTANCE != null) {
                return INSTANCE!!
            }
            synchronized(this) {
                INSTANCE = buildDatabaseInstance(context)
                return INSTANCE!!
            }
        }

        private fun buildDatabaseInstance(context: Context): AlphaDataBase {
            return Room.databaseBuilder(context,
                AlphaDataBase::class.java,
                Constants.DB_NAME).allowMainThreadQueries().build()
        }
    }
}