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

import com.example.kotlinroomdatabase.repository.Response;
import javax.inject.Inject

class QuoteRepository @Inject constructor(private  val quoteService: QuoteService,
                                          private val quoteDatabase: QuoteDatabase,
) {

    var mutableQuoteList = MutableLiveData<Response<QuoteList>>()
    val quoteLiveData : LiveData<Response<QuoteList>>
    get() = mutableQuoteList
    suspend fun getQuotes(page : Int) : Response.Success<QuoteList>? {
        var data: Response.Success<QuoteList>? =  null;
        //if(NetworkUtils.verifyAvailableNetwork(context)){
            try{
                val result = quoteService.getQuotes(page)
                if(result?.body() != null){
                    quoteDatabase.getDao().addQuotes(result.body()!!.results)
                    mutableQuoteList.postValue(Response.Success(result.body()))
                    data = Response.Success(result.body())
                }
            } catch (ex : Exception){
                mutableQuoteList.postValue(Response.Error(ex.message.toString()))
            }
return data
        }
      /*  else{
            val quotes = quoteDatabase.getDao().getResults()
            val quoteList  = QuoteList(1,1,1,quotes,1,1)
            mutableQuoteList.postValue(Response.Success(quoteList))

        }*/


    //}

    suspend fun getQuotesData(page : Int)  {

        //if(NetworkUtils.verifyAvailableNetwork(context)){
        try{
            val result = quoteService.getQuotes(page)
            if(result?.body() != null){
                quoteDatabase.getDao().addQuotes(result.body()!!.results)
                mutableQuoteList.postValue(Response.Success(result.body()))
            }
        } catch (ex : Exception){
            mutableQuoteList.postValue(Response.Error(ex.message.toString()))
        }

    }
}