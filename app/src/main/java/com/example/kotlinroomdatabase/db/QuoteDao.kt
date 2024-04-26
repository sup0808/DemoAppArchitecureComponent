package com.example.kotlinroomdatabase.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kotlinroomdatabase.models.Quote

@Dao
interface QuoteDao {
    @Insert
    suspend fun addQuotes(quotes : List<Quote>)

    @Query("select * from quote")
    fun getResults() : List<Quote>

    //RoomDB Testing
    @Insert
    suspend fun insertQuote(quotes : Quote)

    @Update
    suspend fun updateQuote(quotes : Quote)

    @Query("DELETE FROM quote")
    suspend fun deleteQuote()

    @Query("SELECT * FROM quote")
     fun getQuotes(): LiveData<List<Quote>>


}