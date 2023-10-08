package com.webcode.kotlinstrategysmsemailwhatsapp.components.messager

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.interfaces.ConfirmationSender
import com.webcode.kotlinstrategysmsemailwhatsapp.services.EmailService
import org.springframework.stereotype.Component

@Component
class EmailConfirmationSender(private val emailService: EmailService) : ConfirmationSender {
    override fun sendConfirmation(user: User) {
        emailService.sendEmail(user)
    }
}