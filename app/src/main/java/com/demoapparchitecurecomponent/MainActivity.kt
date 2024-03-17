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

      val job =  GlobalScope.launch {
           val firstItem= flow{
               (1..5).forEach{
                   emit(it)
               }
              }.toList()

          Log.d("ChezzyFlow :: ",firstItem.toString())

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