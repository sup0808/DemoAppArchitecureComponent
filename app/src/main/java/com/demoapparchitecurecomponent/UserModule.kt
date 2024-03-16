package com.demoapparchitecurecomponent

import androidx.core.app.ActivityCompat
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class UserModule {

    @Binds
    abstract fun bindsUserRepository(sqlRepository: SqlRepository) : UserRepository

}