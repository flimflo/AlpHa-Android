package com.flimflo.alpha.ui.games

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.flimflo.alpha.R
import org.json.JSONException
import org.json.JSONObject

class GamesFragment : Fragment() {

    var listener: CommListener? = null

    interface CommListener {
        fun getGamesList(): MutableList<Games>
        fun saveGamesList(gamesList: MutableList<Games>)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is CommListener) {
            context
        } else {
            throw ClassCastException("Interface no implementado")
        }
    }

    private var gamesList: MutableList<Games> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var requestQueue: RequestQueue

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_games, container, false)

        val swipeRefreshLayout: SwipeRefreshLayout = root.findViewById(R.id.swipeGames)
        swipeRefreshLayout.setOnRefreshListener {
            parseGames()

            swipeRefreshLayout.isRefreshing = false
        }

        recyclerView = root.findViewById(R.id.recGames)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }

        requestQueue = Volley.newRequestQueue(requireContext())

        gamesList = listener!!.getGamesList()
        gamesAdapter = GamesAdapter(requireContext(), gamesList)
        recyclerView.adapter = gamesAdapter

        parseGames()

        return root
    }

    lateinit var something: JSONObject

    private fun parseGames() {
        val url = "https://dry-harbor-29135.herokuapp.com/api/leaderboard/table"
        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    gamesList.clear()
                    for (i in 0 until response.length()) {
                        val `object` = response.getJSONObject(i)
                        val team = `object`.getString("teamName")
                        val goals = `object`.getString("goals").toInt()
                        val goalsA = `object`.getString("goalsAgainst").toInt()
                        val points = `object`.getString("points").toInt()
                        gamesList.add(Games(team, goals, goalsA, points))
                    }
                    listener!!.saveGamesList(gamesList)
                    gamesAdapter.notifyDataSetChanged()
                } catch (exp: JSONException) {
                    exp.printStackTrace()
                }
            }
        ) { }
        requestQueue.add(request)
    }
}