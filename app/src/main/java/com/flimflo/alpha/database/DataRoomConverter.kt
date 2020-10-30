package com.flimflo.alpha.database

import androidx.room.TypeConverter
import java.util.*

object DataRoomConverter {
    @JvmStatic
    @TypeConverter
    fun toDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @JvmStatic
    @TypeConverter
    fun toLong(value: Date?): Long? {
        return value?.time
    }
}