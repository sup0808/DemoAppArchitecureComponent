package com.example.kotlinroomdatabase.di

import com.example.kotlinroomdatabase.frgament.SettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeQuoteFragment(): SettingFragment
}