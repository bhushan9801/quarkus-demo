package com.helios.quarkus.demo.rest

import com.helios.quarkus.demo.domain.Page
import com.helios.quarkus.demo.dto.ActorVO
import com.helios.quarkus.demo.services.ActorsService
import javax.ws.rs.BeanParam
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/actors")
class ActorsResource(val service: ActorsService) {

    @GET
    fun list(@BeanParam page: Page): List<ActorVO> {
        return service.list(page)
    }
}