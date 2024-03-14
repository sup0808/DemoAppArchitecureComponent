package com.demoapparchitecurecomponent

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationModule {


   @Named("message")
   @Provides
   fun getNotificationService() :NotificationService{
      return MessageService()
   }

   @Named("email")
   @Provides
   fun getMessageService(emailService: EmailService) :NotificationService{
      return emailService
   }
}