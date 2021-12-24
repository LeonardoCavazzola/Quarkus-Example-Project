package com.first.quarkus.app.resource

import com.first.quarkus.app.common.Logger
import com.first.quarkus.app.dto.input.UserInput
import com.first.quarkus.app.dto.input.toEntity
import com.first.quarkus.app.dto.response.toResponse
import com.first.quarkus.domain.service.UserService
import java.net.URI
import javax.ws.rs.*
import javax.ws.rs.core.Response

@Path("/users")
class UserResource(
    private val userService: UserService,
) : Logger{

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

    @POST
    fun create(input: UserInput): Response =
        userService.create(input.toEntity())
            .toResponse()
            .let { Response.created(createURI(it.id)).entity(it).build() }

    @Path("/{id}")
    @PUT
    fun update(@PathParam("id") id: Long, input: UserInput): Response =
        userService.update(input.toEntity(id))
            .toResponse()
            .let { Response.ok(createURI(it.id)).entity(it).build() }

    private fun createURI(id: Long): URI = URI.create("this.${id}")
}
