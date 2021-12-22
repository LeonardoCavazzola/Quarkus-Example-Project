package com.first.quarkus.domain.service

import com.first.quarkus.domain.entity.User

interface UserService {

    fun create(user: User): User
}
