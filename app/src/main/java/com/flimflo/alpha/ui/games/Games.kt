package com.flimflo.alpha.ui.games

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flimflo.alpha.database.Constants

@Entity(tableName = Constants.TABLE_NAME_GAMES)
class Games (var teamA: String, var teamB: String, var cancha: Int, var hora: String, var date: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}