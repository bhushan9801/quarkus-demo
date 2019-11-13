package com.helios.quarkus.demo

import com.helios.quarkus.demo.domain.Actor
import io.agroal.api.AgroalDataSource
import io.ebean.Ebean
import io.ebean.EbeanServer
import io.ebean.EbeanServerFactory
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class ExampleResource() {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        val actors = Ebean.find(Actor::class.java)
        return "hello"
    }
}