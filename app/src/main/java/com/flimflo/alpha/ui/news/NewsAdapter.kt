package com.flimflo.alpha.ui.news

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flimflo.alpha.R
import com.squareup.picasso.Picasso

class NewsAdapter(private val context: Context, private val newsList: MutableList<News>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = newsList[position]
        val imgUrl = currentItem.imgUrl
        val title = currentItem.title
        val date = currentItem.date
        holder.txtTitle.text = title
        holder.txtDate.text = date
        Picasso.with(context).load(imgUrl).fit().centerInside().into(holder.imgNews)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgNews: ImageView = itemView.findViewById(R.id.imgNewsItem)
        var txtTitle: TextView = itemView.findViewById(R.id.txtTitleNewsItem)
        var txtDate: TextView = itemView.findViewById(R.id.txtDateNewsItem)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                val currentNews = newsList[position]
                val intent = Intent(context, NewsDetail::class.java)
                intent.putExtra(NewsConstants.DATE,currentNews.date)
                intent.putExtra(NewsConstants.IMAGE,currentNews.imgUrl)
                intent.putExtra(NewsConstants.TITLE,currentNews.title)
                intent.putExtra(NewsConstants.DESCRIPTION,currentNews.content)
                context.startActivity(intent)
            }
        }

    }
}