package com.demoapparchitecurecomponent

import android.util.Log
import javax.inject.Inject

interface UserRepository{
    fun saveuser()
}


class SqlRepository @Inject constructor() : UserRepository{

   override fun saveuser(){
        Log.d("Logg saved","SqlRepository")
    }
}


class FirebaseRepository @Inject constructor() : UserRepository{

    override fun saveuser(){
        Log.d("Logg saved","FirebaseRepository")
    }
}