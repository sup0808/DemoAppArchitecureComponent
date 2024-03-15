package com.demoapparchitecurecomponent

import android.app.Application

class UserApplication : Application() {

    lateinit var component : DaggerAppComponent

    override fun onCreate() {
        super.onCreate()
       // component = DaggerUserRegistrationServiceComponent.builder().build()

        component = DaggerAppComponent.builder().build()
    }
}