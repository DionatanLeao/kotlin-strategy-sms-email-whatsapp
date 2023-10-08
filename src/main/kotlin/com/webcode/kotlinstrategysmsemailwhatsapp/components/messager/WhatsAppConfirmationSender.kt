package com.webcode.kotlinstrategysmsemailwhatsapp.components.messager

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.interfaces.ConfirmationSender
import com.webcode.kotlinstrategysmsemailwhatsapp.services.GtiService
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Component
class WhatsAppConfirmationSender(private val gtiService: GtiService) : ConfirmationSender {
    override fun sendConfirmation(user: User) {
        gtiService.sendMessage(user)
        log.info { "Seu código WhatsApp para ativação é: ${user.userConfirmationCode?.confirmationCode} " }
    }
}