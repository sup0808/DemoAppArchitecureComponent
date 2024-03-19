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
import kotlinx.coroutines.flow.*

import com.example.kotlinroomdatabase.repository.Response;
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class QuoteRepository @Inject constructor(private  val quoteService: QuoteService,
                                          private val quoteDatabase: QuoteDatabase) {


        private val _uiQuoteState = MutableStateFlow<Response<QuoteList>>(Response.Loading)
        val uiQuoteState : MutableStateFlow<Response<QuoteList>> =  _uiQuoteState

     suspend fun getQuotes(page : Int){

        //if(NetworkUtils.verifyAvailableNetwork(context)){

           _uiQuoteState.value = Response.Loading

             flow {
                 emit(quoteService.getQuotes(page))
             }
             .flowOn(Dispatchers.IO)
                    .catch {ex->
                        _uiQuoteState.value = Response.Error(ex.message.toString())
                    }
                    .collect {
                        _uiQuoteState.value = Response.Success(it)
                    }
            }
      /*  else{
        flow{
             emit(quoteDatabase.getDao().getResults())
         }.collect{
             _uiQuoteState.value = Response.Success(QuoteList(1,1,1,it,1,1))
         }

        }*/


    //}
}