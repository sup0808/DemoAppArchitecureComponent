package com.demoapparchitecurecomponent

class UserRepositoryService(private val userRepository: UserRepository = UserRepository(),
                            private val emailService: EmailService = EmailService()
) {

    fun registerUser(email : String, password : String){
        userRepository.saveUser(email,password)
        emailService.send("supriya75@gmail.com","364366")
    }
}