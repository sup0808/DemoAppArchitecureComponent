package com.example.kotlinroomdatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinroomdatabase.repository.QuoteRepository
import javax.inject.Inject

open class MainViewModelFactory @Inject constructor(private val repository : QuoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}