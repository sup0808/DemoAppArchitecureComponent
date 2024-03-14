package com.demoapparchitecurecomponent

import javax.inject.Inject
import javax.inject.Named

class UserRepositoryService @Inject constructor(
    private val userRepository: UserRepository ,
    @Named("email")  private val notificationService: NotificationService
) {

    fun registerUser(email : String, password : String){
        userRepository.saveUser(email,password)
        notificationService.send("supriya75@gmail.com","364366")
    }
}