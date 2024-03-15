package com.demoapparchitecurecomponent

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticsModule {

   @Singleton
    @Provides
    fun provideAnalytics() : AnalyticsService{
        return MixPanel()
    }
}