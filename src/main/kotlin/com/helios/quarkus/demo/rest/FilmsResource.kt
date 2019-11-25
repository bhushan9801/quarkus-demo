package com.helios.quarkus.demo.rest

import com.helios.quarkus.demo.domain.Page
import com.helios.quarkus.demo.domain.PagedResult
import com.helios.quarkus.demo.dto.FilmInfoVO
import com.helios.quarkus.demo.dto.FilmVO
import com.helios.quarkus.demo.services.FilmsService
import javax.validation.Valid
import javax.validation.Validator
import javax.ws.rs.BeanParam
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Path("/films")
class FilmsResource(val filmsService: FilmsService, val validator: Validator) {

    @GET
    fun films(@Valid @BeanParam paging: Page): PagedResult<FilmInfoVO> {
        return filmsService.list(paging)
    }

    @GET
    @Path("{id}")
    fun getFilm(@PathParam("id") id: Int): FilmVO {
        return filmsService.get(id)
    }
}
