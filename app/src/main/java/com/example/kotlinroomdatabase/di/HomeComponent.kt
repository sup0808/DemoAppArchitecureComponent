package com.example.kotlinroomdatabase.di


import com.example.kotlinroomdatabase.MainActivity
import com.example.kotlinroomdatabase.frgament.QuoteActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DbModule::class,ViewModelModule::class])
interface HomeComponent {

    fun inject(mainActivity: MainActivity)

    fun injectQuote(mainActivity: QuoteActivity)

   // fun getMap() : Map<String, ViewModel> /// for @StringKey

   // fun getMap() : Map<Class<*>, ViewModel> /// for @ClassKey

}