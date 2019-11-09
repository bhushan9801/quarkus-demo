package com.helios.quarkus.demo

import io.agroal.api.AgroalDataSource
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class ExampleResource(val dataSource: AgroalDataSource) {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello(): String {
        val statement = dataSource.connection.createStatement()
        statement.executeQuery("select * from dual")
        return "hello"
    }
}