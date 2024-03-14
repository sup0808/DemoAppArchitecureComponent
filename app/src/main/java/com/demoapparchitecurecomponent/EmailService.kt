package com.demoapparchitecurecomponent

import android.util.Log
import javax.inject.Inject

class EmailService @Inject constructor() {
    fun send(s: String, s1: String) {
        Log.d("EmailService ","email send")
    }
}