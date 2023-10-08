package com.webcode.kotlinstrategysmsemailwhatsapp.controllers

import com.webcode.kotlinstrategysmsemailwhatsapp.dtos.RegistrationRequestDTO
import com.webcode.kotlinstrategysmsemailwhatsapp.services.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {
    @PostMapping("/register")
    fun registerUser(@Valid @RequestBody request: RegistrationRequestDTO) {
        userService.registerUser(request.userDto.toUser(), request.confirmationMethod)
    }

    @GetMapping("/validate")
    fun validateConfirmationCode(
        @RequestParam email: String,
        @RequestParam code: String
    ): ResponseEntity<Any> {
        return if (userService.validateConfirmationCode(email, code)) {
            ResponseEntity.accepted().build()
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The code has expired, please request another one.")
        }
    }
}