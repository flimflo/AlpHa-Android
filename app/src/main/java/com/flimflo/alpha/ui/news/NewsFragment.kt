package com.flimflo.alpha.ui.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.flimflo.alpha.R
import org.json.JSONException

class NewsFragment : Fragment() {
    var listener: CommListener? = null

    interface CommListener {
        fun getNewsList(): MutableList<News>
        fun saveNewsList(newsList: MutableList<News>)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is CommListener) {
            context
        } else {
            throw ClassCastException("Interface no implementado")
        }
    }

    private var newsList: MutableList<News> = mutableListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var requestQueue: RequestQueue

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_news, container, false)

        val swipeRefreshLayout: SwipeRefreshLayout = root.findViewById(R.id.swipeNews)
        swipeRefreshLayout.setOnRefreshListener {
            parseNews()

            swipeRefreshLayout.isRefreshing = false
        }

        recyclerView = root.findViewById(R.id.recNews)
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
        }

        requestQueue = Volley.newRequestQueue(requireContext())

        newsList = listener!!.getNewsList()
        newsAdapter = NewsAdapter(requireContext(), newsList)
        recyclerView.adapter = newsAdapter

        parseNews()

        return root
    }

    private fun parseNews() {
        val url = "https://dry-harbor-29135.herokuapp.com/api/news"
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    newsList.clear()
                    val temp = response.getJSONArray("articles")
                    for (i in 0 until temp.length()) {
                        val `object` = temp.getJSONObject(i)
                        val title = `object`.getString("title")
                        val date = `object`.getString("date")
                        val content = `object`.getString("content")
                        val img = `object`.getString("image_url")
                        newsList.add(News(img, title, date, content))
                    }
                    listener!!.saveNewsList(newsList)
                    newsAdapter.notifyDataSetChanged()
                } catch (exp: JSONException) {
                    exp.printStackTrace()
                }
            }
        ) { }
        requestQueue.add(request)
    }
}