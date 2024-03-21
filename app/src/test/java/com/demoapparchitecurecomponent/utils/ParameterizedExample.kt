package com.demoapparchitecurecomponent.utils

import android.text.BoringLayout
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized


@RunWith(value = Parameterized::class)
class ParameterizedExample(val input : String, val expectedValue :Boolean) {

    @Test
    fun test(){
        val helper =Helper()
        val result = helper.isPalindrome(input)
        assertEquals(expectedValue,result)
    }

    companion object{

        @JvmStatic
        @Parameterized.Parameters
        fun data():List<Array<Any>>{
            return listOf(
                arrayOf("hello",false),
                arrayOf("level",true),
                arrayOf("a",true),
                arrayOf("",true),
            )
        }
    }
}