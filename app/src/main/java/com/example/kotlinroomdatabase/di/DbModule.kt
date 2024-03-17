package com.example.kotlinroomdatabase.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.kotlinroomdatabase.db.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DbModule {

    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context):QuoteDatabase{
      return  Room.databaseBuilder(
          context,
            QuoteDatabase::class.java,
            "QuotesDB")
            .build()
    }
}