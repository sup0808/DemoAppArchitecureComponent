package com.example.kotlinroomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("select * from contact")
    fun getContact() : LiveData<List<Contact>>
}