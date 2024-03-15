package com.example.kotlinroomdatabase.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.kotlinroomdatabase.db.QuoteDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule(private val application: Context) {

    @Singleton
    @Provides
    fun provideRoomDb():QuoteDatabase{
      return  Room.databaseBuilder(
          application,
            QuoteDatabase::class.java,
            "QuotesDB")
            .build()
    }
}