package com.webcode.kotlinstrategysmsemailwhatsapp.services

import com.webcode.kotlinstrategysmsemailwhatsapp.components.messager.EmailConfirmationSender
import com.webcode.kotlinstrategysmsemailwhatsapp.components.messager.SmsConfirmationSender
import com.webcode.kotlinstrategysmsemailwhatsapp.components.messager.WhatsAppConfirmationSender
import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.enums.ConfirmationMethodEnum
import com.webcode.kotlinstrategysmsemailwhatsapp.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val userConfirmationCodeService: UserConfirmationCodeService,
    private val smsConfirmationSender: SmsConfirmationSender,
    private val emailConfirmationSender: EmailConfirmationSender,
    private val whatsAppConfirmationSender: WhatsAppConfirmationSender
) {

    fun registerUser(user: User, confirmationMethod: ConfirmationMethodEnum) {
        userConfirmationCodeService.createConfirmationCode(userRepository.save(user))
        sendCode(user, confirmationMethod)
    }

    private fun sendCode(user: User, confirmationMethod: ConfirmationMethodEnum) {
        when(confirmationMethod) {
            ConfirmationMethodEnum.SMS -> smsConfirmationSender.sendConfirmation(user)
            ConfirmationMethodEnum.EMAIL -> emailConfirmationSender.sendConfirmation(user)
            ConfirmationMethodEnum.WA -> whatsAppConfirmationSender.sendConfirmation(user)
        }
    }
}