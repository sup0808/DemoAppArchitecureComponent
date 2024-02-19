package com.demoapparchitecurecomponent

import androidx.lifecycle.ViewModel

class MainViewModel(var counter: Int) : ViewModel() {
   // var count: Int = 0
     fun increment() {
        this. counter++

    }
}