package com.webcode.kotlinstrategysmsemailwhatsapp.enums

import com.webcode.kotlinstrategysmsemailwhatsapp.components.messager.EmailConfirmationSender
import com.webcode.kotlinstrategysmsemailwhatsapp.components.messager.SmsConfirmationSender
import com.webcode.kotlinstrategysmsemailwhatsapp.components.messager.WhatsAppConfirmationSender
import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.services.EmailService
import com.webcode.kotlinstrategysmsemailwhatsapp.services.GtiService
import com.webcode.kotlinstrategysmsemailwhatsapp.services.TelesignService
import org.springframework.context.ApplicationContext

enum class ConfirmationMethodEnum {
    SMS,
    EMAIL,
    WA;

    fun sendConfirmation(user: User, ctx: ApplicationContext) {
        when (this) {
            SMS -> {
                val sender = SmsConfirmationSender(ctx.getBean(TelesignService::class.java))
                sender.sendConfirmation(user)
            }

            EMAIL -> {
                val sender = EmailConfirmationSender(ctx.getBean(EmailService::class.java))
                sender.sendConfirmation(user)
            }

            WA -> {
                val sender = WhatsAppConfirmationSender(ctx.getBean(GtiService::class.java))
                sender.sendConfirmation(user)
            }
        }
    }
}