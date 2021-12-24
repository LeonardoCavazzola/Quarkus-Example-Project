package com.first.quarkus.app.config

import com.first.quarkus.app.common.Logger
import java.time.Duration
import java.time.LocalDateTime
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ContainerRequestFilter
import javax.ws.rs.container.ContainerResponseContext
import javax.ws.rs.container.ContainerResponseFilter
import javax.ws.rs.ext.Provider

private var start: LocalDateTime? = null

@Provider
class RequestLoggerInterceptor : ContainerRequestFilter, Logger {
    override fun filter(requestContext: ContainerRequestContext) {
        start = LocalDateTime.now()
        logger.info("Request received with path: (**${requestContext.uriInfo.path}) and method: (${requestContext.method})")
    }
}

@Provider
class ResponseLoggerInterceptor : ContainerResponseFilter, Logger {
    override fun filter(requestContext: ContainerRequestContext, responseContext: ContainerResponseContext) {
        start?.let { Duration.between(start, LocalDateTime.now()).toMillis() }
            ?.let { logger.info("Request completed in $it ms and responded with status: (${responseContext.statusInfo})") }
            ?: logger.warn("Request received with path: (**${requestContext.uriInfo.path}) and method: (${requestContext.method}), but this endpoint does not exist")

        start = null
    }
}
