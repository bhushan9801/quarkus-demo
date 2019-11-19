package com.helios.quarkus.demo.rest

import com.helios.quarkus.demo.domain.Page
import com.helios.quarkus.demo.domain.PagedResult
import com.helios.quarkus.demo.dto.FilmVO
import com.helios.quarkus.demo.services.FilmsService
import javax.validation.Valid
import javax.ws.rs.BeanParam
import javax.ws.rs.GET
import javax.ws.rs.Path

@Path("/films")
class FilmsResource(val filmsService: FilmsService) {

    @GET
    fun films(@Valid @BeanParam paging: Page): PagedResult<FilmVO> = filmsService.list(paging)
}