package com.first.quarkus.app.dto.response

import com.first.quarkus.domain.entity.User

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
