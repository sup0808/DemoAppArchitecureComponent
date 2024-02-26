package com.example.kotlinroomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "users", primaryKeys = ["FirstName","LastName"])
data class User(
    @ColumnInfo(name ="FirstName")
    val first_name : String,
    @ColumnInfo(name = "LastName")
     val last_name : String,
   // @PrimaryKey(autoGenerate = true)
    //val id : String
)