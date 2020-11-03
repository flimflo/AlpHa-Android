package com.flimflo.alpha

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.flimflo.alpha.database.AlphaDataBase
import com.flimflo.alpha.ui.games.Games
import com.flimflo.alpha.ui.games.GamesFragment
import com.flimflo.alpha.ui.news.News
import com.flimflo.alpha.ui.news.NewsFragment
import com.flimflo.alpha.ui.ranking.RankingFragment
import com.flimflo.alpha.ui.ranking.Ranking
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), GamesFragment.CommListener, NewsFragment.CommListener, RankingFragment.CommListener {

    private lateinit var database: AlphaDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = AlphaDataBase.getInstance(this)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_news,
                R.id.navigation_ranking,
                R.id.navigation_games,
                R.id.navigation_sponsors,
                R.id.navigation_rules
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun getGamesList(): MutableList<Games> {
        return database.gamesDao.GetAll()
    }

    override fun saveGamesList(gamesList: MutableList<Games>) {
        database.gamesDao.DeleteAll()
        database.gamesDao.InsertList(gamesList)
    }

    override fun getNewsList(): MutableList<News> {
        return database.newsDao.GetAll()
    }

    override fun saveNewsList(newsList: MutableList<News>) {
        database.newsDao.DeleteAll()
        database.newsDao.InsertList(newsList)
    }

    override fun getRankingList(): MutableList<Ranking> {
        return database.rankingDao.GetAll()
    }

    override fun saveRankingList(rankingList: MutableList<Ranking>) {
        database.rankingDao.DeleteAll()
        database.rankingDao.InsertList(rankingList)
    }

}