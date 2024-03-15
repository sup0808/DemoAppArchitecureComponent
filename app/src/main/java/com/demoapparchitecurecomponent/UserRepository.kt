package com.demoapparchitecurecomponent

import android.util.Log
import javax.inject.Inject

interface  UserRepository{
    fun saveUser(email: String, password: String)
}


@ActivityScope
class SQLRepository @Inject constructor(val analyticsService: AnalyticsService)  : UserRepository{

   override fun saveUser(email: String, password: String) {
        Log.d("UserRepository ","user saved")
    }
}

class RoomDBRepository @Inject constructor(val analyticsService: AnalyticsService)  : UserRepository{

    override fun saveUser(email: String, password: String) {
        Log.d("RoomDBRepository ","user saved")
    }
}