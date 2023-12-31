package com.webcode.kotlinstrategysmsemailwhatsapp.services

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.utils.Constants.DEFAULT_SUBJECT_MAIL
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(private val javaMailSender: JavaMailSender) {

    fun sendEmail(user: User) {
        val messageTxt = "Seu código para ativação é: ${user.userConfirmationCode?.confirmationCode} "
        val message = SimpleMailMessage()
        message.setTo(user.email)
        message.setSubject(DEFAULT_SUBJECT_MAIL)
        message.setText(messageTxt)
        javaMailSender.send(message)
    }
}