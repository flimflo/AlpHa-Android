package com.flimflo.alpha.ui.ranking

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.flimflo.alpha.Enviroment
import com.flimflo.alpha.R
import org.json.JSONException

class RankingFragment : Fragment() {
    var listener: CommListener? = null

    interface CommListener {
        fun getRankingList(): MutableList<Ranking>
        fun saveRankingList(rankingList: MutableList<Ranking>)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is CommListener) {
            context
        } else {
            throw ClassCastException("Interface no implementado")
        }
    }

    private var rankingList: MutableList<Ranking> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var rankingAdapter: RankingAdapter
    private lateinit var requestQueue: RequestQueue

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_ranking, container, false)

        val swipeRefreshLayout: SwipeRefreshLayout = root.findViewById(R.id.swipeRanking)
        swipeRefreshLayout.setOnRefreshListener {
            val toast = Toast.makeText(context, getString(R.string.title_ranking) + " " + getString(R.string.updated), Toast.LENGTH_SHORT)
            toast.show()
            parseRanking()

            swipeRefreshLayout.isRefreshing = false
        }
        recyclerView = root.findViewById(R.id.recRanking)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }

        requestQueue = Volley.newRequestQueue(requireContext())

        rankingList = listener!!.getRankingList()
        rankingAdapter = RankingAdapter(requireContext(), rankingList)
        recyclerView.adapter = rankingAdapter

        parseRanking()

        return root
    }

    private fun parseRanking() {
        val url = Enviroment.getEnviroment() + "/api/leaderboard/table"
        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    rankingList.clear()
                    for (i in 0 until response.length()) {
                        val `object` = response.getJSONObject(i)
                        val teamName = `object`.getString("teamName")
                        val goals = `object`.getString("goals").toInt()
                        val goalsAgainst = `object`.getString("goalsAgainst").toInt()
                        val points = `object`.getInt("points").toInt()
                        rankingList.add(Ranking(teamName, goals, goalsAgainst, points))
                    }
                    listener!!.saveRankingList(rankingList)
                    rankingAdapter.notifyDataSetChanged()

                } catch (exp: JSONException) {
                    exp.printStackTrace()
                }
            }
        ) { }
        requestQueue.add(request)
    }

}