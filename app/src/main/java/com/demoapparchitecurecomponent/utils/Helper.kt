package com.demoapparchitecurecomponent.utils

import org.junit.After
import org.junit.Before

class Helper {



    fun isPalindrome(str : String) : Boolean{
        var i =0
        var j = str.length-1
        var result = true

        while (i<j){
            if(str[i] != str[j]){
                result = false
                break
            }
           i++
            j--
        }
        return result
    }
}