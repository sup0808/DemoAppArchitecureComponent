package com.example.kotlinroomdatabase.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.kotlinroomdatabase.getOrAwaitValue
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
            Mockito.`when`(respository.getQuotes(1)).thenReturn(Response.Success())
            val sut = MainViewModel(respository)
            testDispatcher.scheduler.advanceUntilIdle()
            val result= sut.quotes.getOrAwaitValue()
            Assert.assertEquals(0, result.data?.results!!.size)
        }

    }

   /* @Test
    fun test_getQuotes_error(){
        runTest{
            Mockito.`when`(respository.getQuotes(1)).thenReturn(Response.Error("Something Wrong"))
            val sut = MainViewModel(respository)
            testDispatcher.scheduler.advanceUntilIdle()
            val result= sut.quotes.getOrAwaitValue()
            Assert.assertEquals(true, result is Response.Error)
        }

    }*/

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}