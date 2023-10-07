package com.webcode.kotlinstrategysmsemailwhatsapp.services

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import com.webcode.kotlinstrategysmsemailwhatsapp.entity.UserConfirmationCode
import com.webcode.kotlinstrategysmsemailwhatsapp.repositories.UserConfirmationCodeRepository
import com.webcode.kotlinstrategysmsemailwhatsapp.repositories.UserRepository
import com.webcode.kotlinstrategysmsemailwhatsapp.utils.Constants.MIN_CODE_VALUE
import com.webcode.kotlinstrategysmsemailwhatsapp.utils.Constants.MAX_CODE_VALUE
import com.webcode.kotlinstrategysmsemailwhatsapp.utils.Constants.CODE_LENGTH
import com.webcode.kotlinstrategysmsemailwhatsapp.utils.Constants.ONE
import com.webcode.kotlinstrategysmsemailwhatsapp.utils.Constants.ZERO
import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class UserConfirmationCodeService(
    private val userConfirmationCodeRepository: UserConfirmationCodeRepository
) {

    fun createConfirmationCode(user: User) {
        user.userConfirmationCode = userConfirmationCodeRepository.save(UserConfirmationCode(
            user = user, confirmationCode = generateConfirmationCode()
        )).user?.userConfirmationCode
    }

    private fun generateConfirmationCode() = Random.nextInt(
            MIN_CODE_VALUE,
            MAX_CODE_VALUE + ONE
        ).toString()
            .take(CODE_LENGTH)
            .padStart(CODE_LENGTH, ZERO)
}