package com.example.kotlinroomdatabase.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuoteDao {
    @Insert
    suspend fun addQuotes(quotes : List<com.example.kotlinroomdatabase.models.Quote>)

    @Query("select * from quote")
    fun getResults() : List<com.example.kotlinroomdatabase.models.Quote>
}