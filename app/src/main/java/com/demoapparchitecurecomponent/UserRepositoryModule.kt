package com.demoapparchitecurecomponent

import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule {

    @Provides
    fun getRoomDbRepository(sqlRepository: SQLRepository): UserRepository{ // since @inject constuctor() is used
        return sqlRepository
    }
}