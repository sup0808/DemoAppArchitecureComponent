package com.demoapparchitecurecomponent

import android.util.Log
import javax.inject.Inject

class LoggerService @Inject constructor() {

    fun log(msg : String){
        Log.d("LoggerService ","  :: $msg")

    }
}