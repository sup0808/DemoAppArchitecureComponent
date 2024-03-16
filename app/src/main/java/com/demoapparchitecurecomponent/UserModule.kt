package com.demoapparchitecurecomponent

import androidx.core.app.ActivityCompat
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named
import javax.inject.Qualifier

@InstallIn(ActivityComponent::class)
@Module
class UserModule {

    @Named("sql")
    @Provides
    fun provideSqlRepository(sqlRepository: SqlRepository) : UserRepository{
        return sqlRepository
    }

    @Named("Firebase")
    @Provides
    fun provideFirebaseRepository() : UserRepository{
        return FirebaseRepository()
    }
}