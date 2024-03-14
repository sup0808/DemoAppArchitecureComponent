package com.demoapparchitecurecomponent

import dagger.Component

@Component(modules = [NotificationModule::class, UserRepositoryModule::class])
interface UserRegistrationServiceComponent {

   // fun getUserRepositoryService() : UserRepositoryService

    fun inject(mainActivity: MainActivity)

}