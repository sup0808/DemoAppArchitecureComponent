package com.demoapparchitecurecomponent

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface QuoteDao {
    //RoomDB Testing
    @Insert
    suspend fun insertQuote(quotes : Quote)

    @Update
    suspend fun updateQuote(quotes : Quote)

    @Query("DELETE FROM quote")
    suspend fun deleteQuote()

    @Query("SELECT * FROM quote")
    fun getQuotes(): Flow<List<Quote>>


}