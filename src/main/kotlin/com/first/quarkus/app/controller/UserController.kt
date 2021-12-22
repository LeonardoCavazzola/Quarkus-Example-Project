package com.first.quarkus.app.controller

import com.first.quarkus.app.dto.input.UserInput
import com.first.quarkus.app.dto.input.toEntity
import com.first.quarkus.app.dto.response.toResponse
import com.first.quarkus.domain.service.UserService
import javax.transaction.Transactional
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/users")
class UserController(
    private val userService: UserService
) {

    @POST
    @Transactional
    fun create(userInput: UserInput) = userInput.toEntity().let(userService::create).toResponse()

}
