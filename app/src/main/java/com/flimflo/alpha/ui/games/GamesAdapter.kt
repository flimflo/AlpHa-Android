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
        val teamA = currentItem.teamA
        val teamB = currentItem.teamB
        val cancha = currentItem.cancha
        val hora = currentItem.hora
        holder.txtTeamA.text = teamA
        holder.txtTeamB.text = teamB
        holder.txtCancha.text = cancha.toString()
        holder.txtHora.text = hora
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTeamA: TextView = itemView.findViewById(R.id.txtTeamAGamesItem)
        var txtTeamB: TextView = itemView.findViewById(R.id.txtTeamBGamesItem)
        var txtCancha: TextView = itemView.findViewById(R.id.txtCanGamesItem)
        var txtHora: TextView = itemView.findViewById(R.id.txtHoraGamesItem)

    }
}