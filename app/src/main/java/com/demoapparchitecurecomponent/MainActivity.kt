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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       GlobalScope.launch {
          producer().collect{
                   Log.d("ChezzyFlow 1:: ",it.toString())
               }
      }
        GlobalScope.launch {
          val result =  producer()
            delay(2500)
            result.collect{
                Log.d("ChezzyFlow :: 2 ",it.toString())
            }
        }
    }

    fun producer() :Flow<Int>{
        val mutableSharedFlow = MutableSharedFlow<Int>()

        GlobalScope.launch {
            val list = listOf(1,2,3,4,5)
            list.forEach{
                mutableSharedFlow.emit(it)
                delay(1000)
            }
        }
        return mutableSharedFlow
    }


}