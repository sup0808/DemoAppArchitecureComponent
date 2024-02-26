package com.example.kotlinroomdatabase

import androidx.room.TypeConverter
import java.util.*

class Convertors {

    @TypeConverter
    fun fromDateToLong(value : Date) : Long{
        return value.time
    }

    @TypeConverter
    fun fromLongTodate() : Date {
        return Date()
    }
}