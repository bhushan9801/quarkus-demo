package com.helios.quarkus.demo.rest

import com.helios.quarkus.demo.domain.Mappers
import javax.persistence.EntityManager
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/ping")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class MetricsResource(val em: EntityManager, val mappers: Mappers) {

    @GET
    fun hello(): String {
        return "{\"message\": \"hello\"}"
    }
}