package com.example.kotlinroomdatabase.di

import com.example.kotlinroomdatabase.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}