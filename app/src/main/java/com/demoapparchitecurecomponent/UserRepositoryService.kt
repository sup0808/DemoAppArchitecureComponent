package com.demoapparchitecurecomponent

import javax.inject.Inject

class UserRepositoryService @Inject constructor(private val userRepository: UserRepository ,
                            private val emailService: EmailService
) {

    fun registerUser(email : String, password : String){
        userRepository.saveUser(email,password)
        emailService.send("supriya75@gmail.com","364366")
    }
}