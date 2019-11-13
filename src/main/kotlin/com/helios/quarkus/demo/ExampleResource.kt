package com.helios.quarkus.demo

import com.helios.quarkus.demo.domain.Actor
import com.helios.quarkus.demo.domain.Film
import com.helios.quarkus.demo.domain.Staff
import javax.persistence.EntityManager
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class ExampleResource(val em: EntityManager) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        val actors = em.find(Actor::class.java, 1)
        println(actors)
        println(em.find(Film::class.java, 1))
        val staff = em.find(Staff::class.java, 1)
        println(staff)
        return "hello"
    }
}