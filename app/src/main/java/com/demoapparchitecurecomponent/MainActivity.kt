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
import androidx.lifecycle.lifecycleScope
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
        exampleZip()
        lifecycleScope.launch{
            zipExample()
            zipExampleAnother()
            //combineMultipleFlowExample()
        }


       GlobalScope.launch {
          val result = producer()
           Log.d("ChezzyFlow item  ",result.value.toString())
           delay(6000)
          result.collect{
                   Log.d("ChezzyFlow item  ",it.toString())
               }
      }

    }

    fun exampleZip(){
        val flowOne = flowOf(1,2,3,4)
        val flowTwo = flowOf("A","B","C")

        GlobalScope.launch {
            flowOne.zip(flowTwo){one,two ->
                "$one$two"
            }.collect{
                    println(it)
                }
        }

    }

    fun producer() :StateFlow<Int>{
        val mutableStateFlow = MutableStateFlow(10)

        GlobalScope.launch {
            delay(2000)
            mutableStateFlow.emit(20)
            delay(2000)
            mutableStateFlow.emit(30)

            }

        return mutableStateFlow
    }


}