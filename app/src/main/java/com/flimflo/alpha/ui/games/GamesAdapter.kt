package com.flimflo.alpha.ui.games

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.flimflo.alpha.R

class GamesAdapter(private val context: Context, private val gamesList: MutableList<Games>) :
    RecyclerView.Adapter<GamesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.games_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = gamesList[position]
        val team = currentItem.team
        val goals = currentItem.goals
        val goalsA = currentItem.goalsA
        val points = currentItem.points
        holder.txtTeam.text = team
        holder.txtGoals.text = goals.toString()
        holder.txtGoalsA.text = goalsA.toString()
        holder.txtPoints.text = points.toString()
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTeam: TextView = itemView.findViewById(R.id.txtTitleGamesItem)
        var txtGoals: TextView = itemView.findViewById(R.id.txtPosGamesItem)
        var txtGoalsA: TextView = itemView.findViewById(R.id.txtNegGamesItem)
        var txtPoints: TextView = itemView.findViewById(R.id.txtTotalGamesItem)

    }
}