package com.example.kotlinroomdatabase.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinroomdatabase.db.QuoteDatabase
import com.example.kotlinroomdatabase.models.QuoteList
import com.example.kotlinroomdatabase.repository.QuoteRepository
import com.example.kotlinroomdatabase.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private  val repository: QuoteRepository) : ViewModel(){
    init{
        viewModelScope.launch(Dispatchers.Main) {
            repository.getQuotes(1)
        }
    }

    val quotes : MutableStateFlow<Response<QuoteList>>
        get() = repository.uiQuoteState
}

class Randomize {
    fun doAction(){
        Log.d("MainViewModel ::", "hhjjj")
    }
}