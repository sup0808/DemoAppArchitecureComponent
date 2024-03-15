package com.demoapparchitecurecomponent

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class NotificationModule() {


  @MessageQualifier
  @Singleton
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