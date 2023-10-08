package com.webcode.kotlinstrategysmsemailwhatsapp.dtos

import com.fasterxml.jackson.annotation.JsonAlias
import com.webcode.kotlinstrategysmsemailwhatsapp.enums.ConfirmationMethodEnum

data class RegistrationRequestDTO(
    @JsonAlias("user")
    val userDto: UserDTO,
    val confirmationMethod: ConfirmationMethodEnum
)