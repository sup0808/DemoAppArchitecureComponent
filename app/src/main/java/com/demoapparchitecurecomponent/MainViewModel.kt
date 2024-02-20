package com.demoapparchitecurecomponent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val factMutableLiveData = MutableLiveData<String>("This is a fact.")
    val factLiveData : LiveData<String>
    get() = factMutableLiveData

    fun updateLiveData(){

        factMutableLiveData.value = "Another fact"
    }
}