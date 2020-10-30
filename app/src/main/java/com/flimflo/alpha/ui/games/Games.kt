package com.flimflo.alpha.ui.games

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flimflo.alpha.database.Constants

@Entity(tableName = Constants.TABLE_NAME_GAMES)
class Games (var team: String, var goals: Int, var goalsA: Int, var points: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}