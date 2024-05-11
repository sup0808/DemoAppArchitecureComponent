package com.example.kotlinroomdatabase

import com.example.kotlinroomdatabase.api.QuoteService
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteServiceTest {
    lateinit var mockWebServer: MockWebServer
    lateinit var quoteService: QuoteService

    @Before
    fun setUp(){
        mockWebServer = MockWebServer()
        quoteService = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(QuoteService::class.java)
    }

    @Test
    fun test_getQuotes()= runTest{
        val mockResponse = MockResponse()
        val content = Helper.readFileResource("/QuoteResponse.json")
        mockResponse.setResponseCode(200)
        mockResponse.setBody(content)
        mockWebServer.enqueue(mockResponse)
        val response = quoteService.getQuotes(1)
            mockWebServer.takeRequest()
        Assert.assertEquals(3,response.body()!!.results.size)
    }

    @Test
    fun test_getQuotes_error()= runTest{
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(404)
        mockResponse.setBody("Something wrong")
        mockWebServer.enqueue(mockResponse)
        val response = quoteService.getQuotes(1)
        mockWebServer.takeRequest()
        Assert.assertEquals(false,response.isSuccessful)
        Assert.assertEquals(404,response.code())
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}