package com.webcode.kotlinstrategysmsemailwhatsapp.services

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.feign.clients.TelesignMessagingClient
import org.springframework.stereotype.Service

@Service
class TelesignService(
    private val messagingClient: TelesignMessagingClient
) {
    fun sendSMS(user: User) {
        val phoneNumber = user.phoneNumber
        val message = "Olá ${user.name},seu código de confirmação é: ".plus(user.userConfirmationCode!!.confirmationCode)
        val requestBody = "phone_number=$phoneNumber&message=$message&message_type=ARN"
        messagingClient.sendSMS(requestBody)
    }
}