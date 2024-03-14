package com.demoapparchitecurecomponent

import dagger.Module
import dagger.Provides

@Module
class NotificationModule {

   @Provides
   fun getNotificationService() :NotificationService{
      return MessageService()
   }
}