package com.example.kotlinroomdatabase.repository

import com.example.kotlinroomdatabase.models.QuoteList

/*sealed class Response {

    class Loading : Response()
    class Success(val quoteList: QuoteList) : Response()
    class Error(val errorMessage : String) : Response()
}*/

sealed class Response(val quoteList: QuoteList?=null,val errorMessage : String?=null ) {

    class Loading : Response()
    class Success( quoteList: QuoteList) : Response(quoteList)
    class Error( errorMessage : String) : Response(errorMessage = errorMessage)
}