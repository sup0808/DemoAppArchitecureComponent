package com.demoapparchitecurecomponent

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor() {

    fun saveuser(){
        Log.d("UserRepository ","User saved")
    }
}