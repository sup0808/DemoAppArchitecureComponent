package com.demoapparchitecurecomponent.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    @Before
    fun setUp(){
        println("Before every testcase")
    }

    @After
    fun tearDown(){
        println("After every testcase")
    }

    @Test
    fun isPalindrome() {
        //Arrange
        val helper = Helper()

        //Act
      val result =  helper.isPalindrome("hello")

        //Assert
        assertEquals(false,result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        //Arrange
        val helper = Helper()

        //Act
        val result =  helper.isPalindrome("a")

        //Assert
        assertEquals(true,result)
    }
}