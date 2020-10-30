package com.flimflo.alpha.ui.news

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flimflo.alpha.database.Constants

@Entity(tableName = Constants.TABLE_NAME_NEWS)
class News(var imgUrl: String, var title: String, var date: String, var content: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}