package com.example.kotlinroomdatabase.repository

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinroomdatabase.api.QuoteService
import com.example.kotlinroomdatabase.db.QuoteDatabase
import com.example.kotlinroomdatabase.models.QuoteList
import com.example.kotlinroomdatabase.utils.NetworkUtils
import retrofit2.Response

class QuoteRepository(private  val quoteService: QuoteService,
                      private val quoteDatabase: QuoteDatabase,
                      private  val context : Context ) {

    var mutableQuoteList = MutableLiveData<QuoteList>()
    val quoteLiveData : LiveData<QuoteList>
    get() = mutableQuoteList
    suspend fun getQuotes(page : Int){

        if(NetworkUtils.verifyAvailableNetwork(context)){
            val result = quoteService.getQuotes(page)
            if(result?.body() != null){
                quoteDatabase.getDao().addQuotes(result.body()!!.results)
                mutableQuoteList.postValue(result.body())
            }
        }
        else{
            val quotes = quoteDatabase.getDao().getResults()
            val quoteList  = QuoteList(1,1,1,quotes,1,1)
            mutableQuoteList.postValue(quoteList)

        }


    }
}