package com.example.kotlinroomdatabase.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.kotlinroomdatabase.di.DbModule
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(components = [Singleton::class], replaces = [DbModule::class])
@Module
class TestDatabaseModule {

    @Singleton
    @Provides
    fun provideTestDb(@ApplicationContext context: Context):QuoteDatabase{
        return  Room.inMemoryDatabaseBuilder(
            context,
            QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
    }
}