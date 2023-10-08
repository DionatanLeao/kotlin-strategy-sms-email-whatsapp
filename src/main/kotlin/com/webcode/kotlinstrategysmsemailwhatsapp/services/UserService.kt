package com.webcode.kotlinstrategysmsemailwhatsapp.services

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.enums.ConfirmationMethodEnum
import com.webcode.kotlinstrategysmsemailwhatsapp.exceptions.NotFoundException
import com.webcode.kotlinstrategysmsemailwhatsapp.repositories.UserRepository
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userConfirmationCodeService: UserConfirmationCodeService,
    private val ctx: ApplicationContext
) {

    fun registerUser(user: User, confirmationMethod: ConfirmationMethodEnum) {
        val userSaved = userRepository.save(user)
        userConfirmationCodeService.createConfirmationCode(userSaved)
        confirmationMethod.sendConfirmation(userSaved, ctx)
    }

    fun findByEmailAndCode(email: String, code: String): User? {
        val userConfirmationCode = userConfirmationCodeService.findByEmailAndCode(email, code)
            ?: throw NotFoundException("Usuário ou código não encontrado(s)")

        return userConfirmationCode.user
    }

    fun validateConfirmationCode(email: String, code: String): Boolean {
        val user = findByEmailAndCode(email, code)
        return user?.userConfirmationCode?.isValid() == true
    }
}