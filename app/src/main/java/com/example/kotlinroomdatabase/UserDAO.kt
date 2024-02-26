package com.example.kotlinroomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.w3c.dom.ls.LSInput

@Dao
interface UserDAO {

    @Insert
    suspend fun addUser(user: User)

    @Query("select * from users")
    fun getUsers() : LiveData<List<User>>
}