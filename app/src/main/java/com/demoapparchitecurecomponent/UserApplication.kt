package com.demoapparchitecurecomponent

import android.app.Application

class UserApplication : Application() {

    lateinit var component : UserRegistrationServiceComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerUserRegistrationServiceComponent.builder().build()
    }
}