package com.first.quarkus.response

import com.first.quarkus.model.User

class UserResponse(
    val id: Long,
    val name: String,
    val email: String,
)

fun User.toResponse() =
    UserResponse(
        id = id!!,
        name = name,
        email = email,
    )
