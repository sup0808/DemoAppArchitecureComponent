package com.example.kotlinroomdatabase

import android.app.Application
import com.example.kotlinroomdatabase.api.DaggerHomeComponent
import com.example.kotlinroomdatabase.api.QuoteService
import com.example.kotlinroomdatabase.api.RetrofitHelper
import com.example.kotlinroomdatabase.db.QuoteDatabase
import com.example.kotlinroomdatabase.di.HomeComponent
import com.example.kotlinroomdatabase.repository.QuoteRepository

class QuoteApplication: Application() {

    lateinit var quoteRepository: QuoteRepository
    lateinit var component: HomeComponent
    override fun onCreate() {
        super.onCreate()
         component = DaggerHomeComponent.builder().build()

        initialize()
    }

   private fun initialize(){

       val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
       val database = QuoteDatabase.getDatabase(applicationContext)
       quoteRepository = QuoteRepository(quoteService,database,applicationContext)
    }
}