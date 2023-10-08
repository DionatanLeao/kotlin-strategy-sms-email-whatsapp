package com.webcode.kotlinstrategysmsemailwhatsapp.dtos

data class ErrorResponseDTO(
    val status: Int,
    val error: String,
    val message: String
)