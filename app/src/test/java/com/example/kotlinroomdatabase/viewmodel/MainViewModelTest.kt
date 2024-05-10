package com.example.kotlinroomdatabase.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.kotlinroomdatabase.getOrAwaitValue
import com.example.kotlinroomdatabase.models.Quote
import com.example.kotlinroomdatabase.models.QuoteList
import com.example.kotlinroomdatabase.repository.QuoteRepository
import com.example.kotlinroomdatabase.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.Assert.*

import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get: Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var respository : QuoteRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun test_getQuotes(){
        runTest{
            val quoteList = listOf<Quote>(
                Quote(1,"kkk","bbb","jj","kk","kk","kk",4),
                Quote(1,"kkk","bbb","jj","kk","kk","kk",4)
            )
            Mockito.`when`(respository.getQuotes(1)).thenReturn(Response.Success(QuoteList(
                1,0,1,quoteList,8,9
            )))
            val sut = MainViewModel(respository)
            testDispatcher.scheduler.advanceUntilIdle()
            val result= sut.quotes.getOrAwaitValue()
            Assert.assertEquals(2, result.data?.results!!.size)
        }

    }



    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}