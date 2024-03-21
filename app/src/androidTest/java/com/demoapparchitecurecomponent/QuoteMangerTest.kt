package com.demoapparchitecurecomponent

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.Test
import java.io.FileNotFoundException

class QuoteMangerTest {

    @Test(expected= FileNotFoundException::class)
    fun populateQuoteFromAsset() {
        val quoteManger = QuoteManger()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManger.populateQuoteFromAsset(context," ")
    }

    @Test(expected= JsonSyntaxException::class)
    fun testpopulateQuoteFromAsset_Invalid_Json() {
        val quoteManger = QuoteManger()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManger.populateQuoteFromAsset(context,"quote.json")
    }

    @Test
    fun testpopulateQuoteFromAsset_ValidJson_expected_Count() {
        val quoteManger = QuoteManger()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManger.populateQuoteFromAsset(context,"quote.json")
        assertEquals(6,quoteManger.quoteList.size)
    }
}