package com.example.kotlinroomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @ColumnInfo(name ="FirstName")
    val first_name : String,
    @ColumnInfo(name = "LastName")
    val last_name : String
)