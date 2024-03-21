package com.demoapparchitecurecomponent

import android.content.Context
import com.google.gson.Gson
import java.io.InputStream
import java.nio.charset.Charset

class QuoteManger {

    var quoteList = emptyArray<Quote>()
    var currentQuoteIndex = 0

    fun populateQuoteFromAsset(context : Context, fileName : String){
        val inputStream = context.assets.open(fileName)
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quoteList = gson.fromJson(json,Array<Quote>::class.java)

    }
}