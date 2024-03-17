package com.demoapparchitecurecomponent

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.demoapparchitecurecomponent.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      val job =  GlobalScope.launch(Dispatchers.Main) {
          flow{
               (1..5).forEach{
                   Log.d("ChezzyFlow :: Emiiter Thread",Thread.currentThread().name)
                   emit(it)
               }
          }.flowOn(Dispatchers.IO)
              .collect{
                   Log.d("ChezzyFlow :: Collector Thread",Thread.currentThread().name)
               }



        }



    }

    fun producer() = flow<Int>{
        val list = listOf(1,2,3,4,5)
        list.forEach{
            delay(1000)
            emit(it)
        }
    }


}