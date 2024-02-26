package com.example.kotlinroomdatabase

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.room.Room

import com.example.kotlinroomdatabase.databinding.ActivityMainBinding

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var database: ContactDatabase
    val DATABASE_NAME ="ContactDB"

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        database =  ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"Supriya","9599694764", "Date()",5))
        }

        val conatcts = database.contactDao().getContact()
        conatcts.observe(this, Observer {
            println(it)
        })
    }


}