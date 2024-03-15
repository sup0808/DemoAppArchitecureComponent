package com.example.kotlinroomdatabase.di

import com.example.kotlinroomdatabase.api.QuoteService
import com.example.kotlinroomdatabase.api.RetrofitHelper
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    val BASE_URL = "https://quotable.io/"
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
       return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitApi(retrofit: Retrofit) :QuoteService{
        return retrofit.create(QuoteService::class.java)
    }
}