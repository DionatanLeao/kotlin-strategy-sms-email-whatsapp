package com.webcode.kotlinstrategysmsemailwhatsapp.interfaces

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User

interface ConfirmationSender {
    fun sendConfirmation(user: User)
}