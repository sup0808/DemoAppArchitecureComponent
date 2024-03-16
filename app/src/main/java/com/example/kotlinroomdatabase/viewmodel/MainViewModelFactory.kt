package com.example.kotlinroomdatabase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinroomdatabase.repository.QuoteRepository
import javax.inject.Inject

open class MainViewModelFactory (private val map : Map<Class<*>, @JvmSuppressWildcards ViewModel>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}