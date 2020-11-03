package com.flimflo.alpha.ui.ranking

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flimflo.alpha.database.Constants

@Entity(tableName = Constants.TABLE_NAME_RANKING)
class Ranking (var team: String, var goals: Int, var goalsAgainst: Int, var points: Int){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}