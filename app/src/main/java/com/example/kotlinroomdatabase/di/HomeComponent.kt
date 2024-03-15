package com.example.kotlinroomdatabase.di

import com.example.kotlinroomdatabase.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DbModule::class])
interface HomeComponent {

    fun inject(mainActivity: MainActivity)


}