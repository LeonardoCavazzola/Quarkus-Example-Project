package com.first.quarkus.input

import com.first.quarkus.model.User

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
