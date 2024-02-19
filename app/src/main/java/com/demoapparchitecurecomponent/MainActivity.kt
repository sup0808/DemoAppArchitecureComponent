package com.demoapparchitecurecomponent

import android.app.Notification.Action
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View.OnClickListener
import androidx.lifecycle.ViewModelProvider
import com.demoapparchitecurecomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(applicationContext))[MainViewModel::class.java]

        setQuote(mainViewModel.getQuote())
        binding.btnNext.setOnClickListener{
            setQuote(mainViewModel.nextQuote())
        }

        binding.btnPrevious.setOnClickListener(previousClick)
        binding.btnShare.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type= "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.getQuote().text)
            startActivity(intent)
        }
    }

    private val previousClick : OnClickListener = OnClickListener {
        setQuote(mainViewModel.previosQuote())
    }

    private fun setQuote(quote : Quotes){
        binding.txtTitle.text = quote.text
        binding.txtWriter.text = quote.author
    }




}