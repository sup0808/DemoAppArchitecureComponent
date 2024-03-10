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

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
         }
    }

    suspend fun printFollowers(){
        var fbFolloers =  0
        var instaFollowers = 0
          val job1 =   CoroutineScope(Dispatchers.IO).launch {
                    fbFolloers= getFBFollowers()
        }

        val job2 =   CoroutineScope(Dispatchers.IO).launch {
            fbFolloers= getInstaFollowers()
        }

        job1.join()
        job2.join()
        Log.d("MainActivity :: ",fbFolloers.toString() +" :: " +instaFollowers.toString())
    }

    suspend fun getFBFollowers(): Int{
        delay(1000)
        return  54
    }

    suspend fun getInstaFollowers(): Int{
        delay(1000)
        return  67
    }


}


// output
//D/MainActivity ::: 54 :: 67