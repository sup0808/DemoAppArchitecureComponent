package com.demoapparchitecurecomponent

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationModule(private val retryCount : Int) {


  @MessageQualifier
   @Provides
   fun getNotificationService() :NotificationService{
      return MessageService(retryCount)
   }

   @Named("email")
   @Provides
   fun getMessageService(emailService: EmailService) :NotificationService{
      return emailService
   }
}