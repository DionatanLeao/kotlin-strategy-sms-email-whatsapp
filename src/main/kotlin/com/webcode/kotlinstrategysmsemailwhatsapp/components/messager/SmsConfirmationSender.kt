package com.webcode.kotlinstrategysmsemailwhatsapp.components.messager

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.interfaces.ConfirmationSender
import com.webcode.kotlinstrategysmsemailwhatsapp.services.TelesignService
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class SmsConfirmationSender(private val telesignService: TelesignService) : ConfirmationSender {
    override fun sendConfirmation(user: User) {
        telesignService.sendSMS(user)
        log.info { "Seu código SMS para ativação é: ${user.userConfirmationCode?.confirmationCode} " }
    }
}