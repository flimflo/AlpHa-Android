package com.flimflo.alpha.ui.games

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.flimflo.alpha.Enviroment
import com.flimflo.alpha.R
import com.flimflo.alpha.ui.news.News
import kotlinx.android.synthetic.main.fragment_games.*
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
            val toast = Toast.makeText(context, getString(R.string.title_games) +  " " + getString(R.string.updated), Toast.LENGTH_SHORT)
            toast.show()

            swipeRefreshLayout.isRefreshing = false
        }

        recyclerView = root.findViewById(R.id.recGames)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }

        requestQueue = Volley.newRequestQueue(requireContext())

        gamesList = listener!!.getGamesList()
        val txtDate = root.findViewById<TextView>(R.id.txtDateGames)
        if(gamesList.size != 0){
            txtDate.text = gamesList[0].date
        }
        gamesAdapter = GamesAdapter(requireContext(), gamesList)
        recyclerView.adapter = gamesAdapter

        parseGames()

        return root
    }

    private fun parseGames() {
        val url = Enviroment.getEnviroment() + "/api/weeklymatch"
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    gamesList.clear()
                    val date = response.getString("date")
                    txtDateGames.text = date
                    val temp = response.getJSONArray("roles")
                    for (i in 0 until temp.length()) {
                        val `object` = temp.getJSONObject(i)
                        val teamA = `object`.getString("equipoA")
                        val teamB = `object`.getString("equipoB")
                        val cancha = `object`.getInt("cancha")
                        val hora = `object`.getString("hora")
                        gamesList.add(Games(teamA, teamB, cancha, hora, date))
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