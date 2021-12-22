package com.first.quarkus.app.dto.input

import com.first.quarkus.domain.entity.User

data class UserInput(
    val name: String,
    val email: String,
    val password: String,
)

fun UserInput.toEntity() =
    User(
        name = name,
        email = email,
        password = password,
    )
