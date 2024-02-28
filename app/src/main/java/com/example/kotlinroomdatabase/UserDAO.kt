package com.example.kotlinroomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.w3c.dom.ls.LSInput

@Dao
abstract class UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //@Insert
    abstract suspend fun addUser(user: User)

    @Query("select * from users")
    abstract fun getUsers() : LiveData<List<User>>
}