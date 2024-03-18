package com.example.kotlinroomdatabase.di

import androidx.lifecycle.ViewModel
import com.example.kotlinroomdatabase.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DbModule::class,ViewModelModule::class])
interface HomeComponent {

    fun inject(mainActivity: MainActivity)

   // fun getMap() : Map<String, ViewModel> /// for @StringKey

   // fun getMap() : Map<Class<*>, ViewModel> /// for @ClassKey

}