package com.demoapparchitecurecomponent

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
import com.demoapparchitecurecomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


   private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        var quotesObj = Quotes("\"Do or do that you want\"","Supriya Gupta")

       binding.quotes = quotesObj


    }


}