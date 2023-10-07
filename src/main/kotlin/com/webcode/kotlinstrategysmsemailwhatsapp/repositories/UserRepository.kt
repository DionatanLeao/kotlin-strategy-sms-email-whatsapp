package com.webcode.kotlinstrategysmsemailwhatsapp.repositories

import com.webcode.kotlinstrategysmsemailwhatsapp.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: CrudRepository<User, Long>