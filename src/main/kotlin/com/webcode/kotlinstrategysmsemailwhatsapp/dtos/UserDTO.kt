package com.webcode.kotlinstrategysmsemailwhatsapp.dtos

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User

data class UserDTO(
    val username: String,
    val email: String,
    val phoneNumber: String
) {
    fun toUser(): User {
        return User(
            name = username,
            email = email,
            phoneNumber = phoneNumber
        )
    }
}