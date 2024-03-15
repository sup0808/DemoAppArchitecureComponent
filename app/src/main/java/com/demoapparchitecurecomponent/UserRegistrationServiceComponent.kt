package com.demoapparchitecurecomponent

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton



@ActivityScope
@Component( dependencies = [AppComponent::class], modules = [NotificationModule::class, UserRepositoryModule::class])
interface UserRegistrationServiceComponent {

   // fun getUserRepositoryService() : UserRepositoryService

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance retryCount : Int, appComponent: AppComponent) : UserRegistrationServiceComponent
    }

}