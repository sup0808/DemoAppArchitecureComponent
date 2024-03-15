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
import com.demoapparchitecurecomponent.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var appComponent : AppComponent

    @Inject
    lateinit var userRepositoryService: UserRepositoryService

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appComponent = (application as UserApplication).component

        val userRegistrationServiceComponent = DaggerUserRegistrationServiceComponent.factory().create(2,appComponent)
        userRegistrationServiceComponent.inject(this)

        userRepositoryService.registerUser("njnn","jjj")

    }


}