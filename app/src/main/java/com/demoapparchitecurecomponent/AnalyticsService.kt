package com.demoapparchitecurecomponent

import android.util.Log

interface AnalyticsService {

    fun trackEvent(eventName : String, eventType : String)
}

class MixPanel() : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("MixPanel :: " ,"  $eventName :: $eventType")
    }
}

class Firebase() : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("Firebase :: " ,"  $eventName :: $eventType")
    }
}