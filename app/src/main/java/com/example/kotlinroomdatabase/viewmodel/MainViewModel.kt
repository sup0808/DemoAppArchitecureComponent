package com.example.kotlinroomdatabase.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinroomdatabase.db.QuoteDatabase
import com.example.kotlinroomdatabase.models.QuoteList
import com.example.kotlinroomdatabase.repository.QuoteRepository
import com.example.kotlinroomdatabase.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private  val repository: QuoteRepository) : ViewModel(){

    var quotesMutableLiveData = MutableLiveData<Response<QuoteList>>()
    val quotes : LiveData<Response<QuoteList>>
        get() = quotesMutableLiveData

    init{
        getQuoteData();
    }

    fun getQuoteData(){
        viewModelScope.launch{
            val result = repository.getQuotes(1)
            quotesMutableLiveData.postValue(result)
        }
    }

    val quotesData : LiveData<Response<QuoteList>>
        get() = repository.quoteLiveData
}


class Randomize {
    fun doAction(){
        Log.d("MainViewModel ::", "hhjjj")
    }
}