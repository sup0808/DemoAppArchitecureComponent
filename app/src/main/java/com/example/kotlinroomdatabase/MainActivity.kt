package com.example.kotlinroomdatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*


import com.example.kotlinroomdatabase.databinding.ActivityMainBinding
import com.example.kotlinroomdatabase.repository.Response
import com.example.kotlinroomdatabase.viewmodel.MainViewModel
import com.example.kotlinroomdatabase.viewmodel.MainViewModelFactory

import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    val DATABASE_NAME ="ContactDB"
    @Inject
    lateinit var mainViewModel : MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

      // val map =  (application as QuoteApplication).component.getMap()

        (application as QuoteApplication).component.inject(this)
        mainViewModel = ViewModelProvider(this,mainViewModelFactory)[MainViewModel::class.java]



        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment,R.id.searchFragment,R.id.drawer_layout)
        )

        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)
        binding.navView.setupWithNavController(navController)

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
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }


}