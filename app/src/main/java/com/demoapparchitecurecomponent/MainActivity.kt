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
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.demoapparchitecurecomponent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var count: Int = 0

    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel : MainViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MainViewModelFactory(10))[MainViewModel::class.java]

        binding.button.setOnClickListener(incrementClick)
        binding.button.setOnClickListener {
            viewModel.increment()
            setText()
        }
    }

    var incrementClick: View.OnClickListener = View.OnClickListener {
        //increment()
    }

    private fun setText() {

        binding.textView.text = viewModel.counter.toString()
    }


}

/*
*
* /**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main(args : Array<String>){
  InitOrderDemo("Supriya",13)
 // User("Arvind")
}

class InitOrderDemo(name: String) {
    //val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    constructor InitOrderDemo(name: String, age: Int) : this(name){
        //println("Secondary Constructor $age")
    }


}

class User(name : String){
   // println("First Property ")
    val firstPropert = "$name".also(::println)
    init{
        println("$name")
    }
}*/