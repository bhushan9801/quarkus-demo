package com.helios.quarkus.demo.services

import com.helios.quarkus.demo.domain.Film
import com.helios.quarkus.demo.domain.Mappers
import com.helios.quarkus.demo.dto.FilmVO
import javax.inject.Singleton
import javax.persistence.EntityManager

@Singleton
class FilmsService(em: EntityManager, val mappers: Mappers) : BaseService<Film, FilmVO>(em, Film::class.java) {
    override fun convert(source: Film): FilmVO {
        return mappers.filmToVO(source)
    }

}
