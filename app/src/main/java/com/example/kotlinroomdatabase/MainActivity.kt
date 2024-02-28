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
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.kotlinroomdatabase.api.QuoteService
import com.example.kotlinroomdatabase.api.RetrofitHelper


import com.example.kotlinroomdatabase.databinding.ActivityMainBinding
import com.example.kotlinroomdatabase.repository.QuoteRepository
import com.example.kotlinroomdatabase.viewmodel.MainViewModel
import com.example.kotlinroomdatabase.viewmodel.MainViewModelFactory

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    val DATABASE_NAME ="ContactDB"
    lateinit var mainViewModel : MainViewModel

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository))[MainViewModel::class.java]

        mainViewModel.quotes.observe(this) {
            println("Result :: ${it.results.toString()}")
        }

    }


}