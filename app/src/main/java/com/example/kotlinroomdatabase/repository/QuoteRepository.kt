package com.example.kotlinroomdatabase.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinroomdatabase.api.QuoteService
import com.example.kotlinroomdatabase.models.QuoteList
import retrofit2.Response

class QuoteRepository(private  val quoteService: QuoteService) {

    var mutableQuoteList = MutableLiveData<QuoteList>()
    val quoteLiveData : LiveData<QuoteList>
    get() = mutableQuoteList
    suspend fun getQuotes(page : Int){
        val result = quoteService.getQuotes(page)
        if(result?.body() != null){
            mutableQuoteList.value = result.body()
        }
    }
}