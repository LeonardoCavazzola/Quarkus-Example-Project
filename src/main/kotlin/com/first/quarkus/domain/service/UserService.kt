package com.first.quarkus.domain.service

import com.first.quarkus.domain.entity.User

interface UserService {

    fun findOneById(id: Long): User?

    fun findAll(): List<User>

    fun create(user: User): User
}
