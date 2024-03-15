package com.demoapparchitecurecomponent

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationModule() {


  @MessageQualifier
   @Provides
   fun getNotificationService(retryCount : Int) :NotificationService{
      return MessageService(retryCount)
   }

   @Named("email")
   @Provides
   fun getMessageService(emailService: EmailService) :NotificationService{
      return emailService
   }
}