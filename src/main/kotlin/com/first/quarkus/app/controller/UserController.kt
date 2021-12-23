package com.first.quarkus.app.controller

import com.first.quarkus.app.dto.input.UserInput
import com.first.quarkus.app.dto.input.toEntity
import com.first.quarkus.app.dto.response.toResponse
import com.first.quarkus.domain.service.UserService
import java.net.URI
import javax.transaction.Transactional
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.core.Response

@Path("/users")
class UserController(
    private val userService: UserService
) {

    @Path("/{id}")
    @GET
    fun getOneById(@PathParam("id") id: Long): Response =
        userService.findOneById(id)
            ?.toResponse()
            ?.let { Response.ok(it).build() }
            ?: Response.status(404).build()

    @GET
    fun getAll(): Response =
        userService.findAll()
            .map { it.toResponse() }
            .let { Response.ok(it).build() }

    @Transactional
    @POST
    fun create(userInput: UserInput): Response =
        userService.create(userInput.toEntity())
            .toResponse()
            .let { Response.created(URI.create("users/${it.id}")).entity(it).build() }

}
