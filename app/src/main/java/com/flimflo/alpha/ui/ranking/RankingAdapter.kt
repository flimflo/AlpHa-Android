package com.flimflo.alpha.ui.ranking
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flimflo.alpha.R
import com.flimflo.alpha.ui.news.News
import com.flimflo.alpha.ui.news.NewsAdapter
import com.squareup.picasso.Picasso

class RankingAdapter(private val context: Context, private val rankingList: MutableList<Ranking>):
    RecyclerView.Adapter<RankingAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ranking_item, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rankingList[position]
        val nombre = currentItem.team
        val points = currentItem.points
        val goals = currentItem.goals
        val goalsAgainst = currentItem.goalsAgainst
        holder.txtTeam.text = nombre
        holder.txtGoals.text = goals.toString();
        holder.txtGoalsAgainst.text =goalsAgainst.toString();
        holder.txtPoints.text = points.toString();
        holder.txtPosition.text = (position+1).toString();
    }

    override fun getItemCount(): Int {
        return rankingList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTeam: TextView = itemView.findViewById(R.id.tvEquipo)
        var txtPoints: TextView = itemView.findViewById(R.id.tvPuntos)
        var txtGoals : TextView = itemView.findViewById(R.id.tvGoals)
        var txtGoalsAgainst : TextView = itemView.findViewById(R.id.tvGoalsAgainst)
        var txtPosition : TextView = itemView.findViewById(R.id.tvPosition)

    }
}