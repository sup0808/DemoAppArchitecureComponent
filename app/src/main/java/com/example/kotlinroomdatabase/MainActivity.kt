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
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.room.Room
import com.example.kotlinroomdatabase.api.QuoteService
import com.example.kotlinroomdatabase.api.RetrofitHelper


import com.example.kotlinroomdatabase.databinding.ActivityMainBinding
import com.example.kotlinroomdatabase.repository.QuoteRepository
import com.example.kotlinroomdatabase.repository.Response
import com.example.kotlinroomdatabase.viewmodel.MainViewModel
import com.example.kotlinroomdatabase.viewmodel.MainViewModelFactory

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    val DATABASE_NAME ="ContactDB"
    lateinit var mainViewModel : MainViewModel

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)


        val repository = (application as QuoteApplication).quoteRepository
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository = repository))[MainViewModel::class.java]


        mainViewModel.quotes.observe(this) {
          when(it){
              is Response.Loading ->{}
              is Response.Success ->{
                  it.data?.let { it ->
                      Toast.makeText(this,"Result :: ${it.results.size}", Toast.LENGTH_LONG).show()
                  }
              }
              is Response.Error -> {
                  Toast.makeText(this,it.errorMessage.toString(), Toast.LENGTH_LONG).show()
              }

          }

        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}