package com.demoapparchitecurecomponent

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserRepositoryModule {

    @Binds
    abstract fun getRoomDbRepository(sqlRepository: SQLRepository): UserRepository // since @inject constuctor() is used

}