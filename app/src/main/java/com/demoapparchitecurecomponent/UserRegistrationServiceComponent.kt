package com.demoapparchitecurecomponent

import dagger.Component

@Component
interface UserRegistrationServiceComponent {

    fun getUserRepositoryService() : UserRepositoryService

    fun inject(mainActivity: MainActivity)

}