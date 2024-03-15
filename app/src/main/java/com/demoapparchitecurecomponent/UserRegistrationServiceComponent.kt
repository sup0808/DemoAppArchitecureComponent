package com.demoapparchitecurecomponent

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton



@ActivityScope
@Subcomponent(modules = [NotificationModule::class, UserRepositoryModule::class])
interface UserRegistrationServiceComponent {


    fun inject(mainActivity: MainActivity)


}