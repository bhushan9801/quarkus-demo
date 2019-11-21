package com.helios.quarkus.demo.services

import com.helios.quarkus.demo.domain.Film
import com.helios.quarkus.demo.domain.Mappers
import com.helios.quarkus.demo.dto.FilmInfoVO
import com.helios.quarkus.demo.dto.FilmVO
import javax.inject.Singleton
import javax.persistence.EntityManager
import kotlin.reflect.jvm.javaType

@Singleton
class FilmsService(em: EntityManager, val mappers: Mappers) : BaseService<Film, FilmVO, FilmInfoVO>(em, Film::class.java) {
    override fun convert(source: Film): FilmVO {
        return mappers.filmToVO(source)
    }

    override fun convertInfo(source: Film): FilmInfoVO {
        return mappers.filmToInfoVO(source)
    }
}
