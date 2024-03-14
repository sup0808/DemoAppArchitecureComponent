package com.demoapparchitecurecomponent

import dagger.Module
import dagger.Provides

@Module
class UserRepositoryModule {

    @Provides
    fun getRoomDbRepository(): UserRepository{
        return RoomDBRepository()
    }
}