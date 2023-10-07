package com.webcode.kotlinstrategysmsemailwhatsapp.components.messager

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.interfaces.ConfirmationSender
import org.springframework.stereotype.Component

@Component
class EmailConfirmationSender: ConfirmationSender {
    override fun sendConfirmation(user: User) {

    }
}