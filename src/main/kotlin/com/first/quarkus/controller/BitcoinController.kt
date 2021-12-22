package com.first.quarkus.controller

import com.first.quarkus.model.Bitcoin
import java.math.BigDecimal
import java.time.LocalDate
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/bitcoins")
class BitcoinController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll() = listOf(
        Bitcoin(
            id = 1,
            value = BigDecimal.TEN,
            type = "sei la",
            date = LocalDate.now()
        )
    )

}
