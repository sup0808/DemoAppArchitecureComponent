package com.demoapparchitecurecomponent

import android.util.Log
import javax.inject.Inject




class UserRepository @Inject constructor(private val loggerService: LoggerService) {

    fun saveuser(){
        loggerService.log("Logg saved")
    }
}