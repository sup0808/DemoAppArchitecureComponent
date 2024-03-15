package com.demoapparchitecurecomponent

import android.util.Log
import javax.inject.Inject

interface NotificationService{
    fun send(to: String, body: String)
}


class EmailService @Inject constructor() : NotificationService{
    override fun send(to: String, body: String) {
        Log.d("EmailService ","email send")
    }
}

class MessageService( private val retryCount : Int) : NotificationService{
    override fun send(to: String, body: String) {
        Log.d("MessageService ","email send :: $retryCount")
    }

}