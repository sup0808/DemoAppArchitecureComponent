package com.example.kotlinroomdatabase

import android.app.Application

import com.example.kotlinroomdatabase.di.DaggerHomeComponent
import com.example.kotlinroomdatabase.di.DbModule
import com.example.kotlinroomdatabase.di.HomeComponent

class QuoteApplication: Application() {


    lateinit var component: HomeComponent
    override fun onCreate() {
        super.onCreate()
         component = DaggerHomeComponent.builder().dbModule(DbModule(application = applicationContext)).build()

    }


}