package com.demoapparchitecurecomponent

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuoteDao {
    @Insert
    suspend fun insertQuote(quotes : Quote)

    @Update
    suspend fun updateQuote(quotes : Quote)


}