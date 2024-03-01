package com.example.kotlinroomdatabase

import android.app.Application
import com.example.kotlinroomdatabase.api.QuoteService
import com.example.kotlinroomdatabase.api.RetrofitHelper
import com.example.kotlinroomdatabase.db.QuoteDatabase
import com.example.kotlinroomdatabase.repository.QuoteRepository

class QuoteApplication: Application() {

    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

   private fun initialize(){
       val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
       val database = QuoteDatabase.getDatabase(applicationContext)
       quoteRepository = QuoteRepository(quoteService,database,applicationContext)
    }
}