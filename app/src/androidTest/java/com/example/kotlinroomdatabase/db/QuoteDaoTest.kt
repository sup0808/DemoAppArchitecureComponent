package com.example.kotlinroomdatabase.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.kotlinroomdatabase.models.Quote
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuoteDaoTest {

    @get:Rule
    val instantiationException =  InstantTaskExecutorRule()
    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quoteDao: QuoteDao

    @Before
    fun setUp(){
        quoteDatabase = Room.inMemoryDatabaseBuilder(
                         ApplicationProvider.getApplicationContext(),
                         QuoteDatabase::class.java
                ).allowMainThreadQueries().build()

        quoteDao = quoteDatabase.getDao()


    }

    @After
    fun tearDown(){
        quoteDatabase.close()
    }

    @Test
    fun insert_expectedSingleQuote() = runBlocking {
        val quote = Quote(1,"Supriya","Gupta",
            "Tetsing room DB","yes","123","dhd",2)
        quoteDao.insertQuote(quote)

        val result = quoteDao.getQuotes().getOrAwaitValue()

        assertEquals(1,result.size)
        assertEquals("Gupta",result[0].author)
    }

    @Test
    fun delete_expectedNoValue()= runBlocking {
        val quote = Quote(1,"Supriya","Gupta",
            "Tetsing room DB","yes","123","dhd",2)
        quoteDao.insertQuote(quote)

        quoteDao.deleteQuote()

        val result = quoteDao.getQuotes().getOrAwaitValue()

        assertEquals(0,result.size)


    }
}