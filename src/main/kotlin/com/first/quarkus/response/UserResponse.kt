package com.first.quarkus.response

import com.first.quarkus.model.User

class UserResponse(
    val name: String,
    val email: String,
)

fun User.toResponse() =
    UserResponse(
        name = "name",
        email = "email@email",
    )
