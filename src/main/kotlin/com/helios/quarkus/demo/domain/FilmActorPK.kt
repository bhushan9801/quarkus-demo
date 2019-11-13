package com.helios.quarkus.demo.domain

import javax.persistence.Column
import javax.persistence.Id

open class FilmActorPK : java.io.Serializable {
    @field:Id
    @field:Column(name = "actor_id", nullable = false, insertable = false, updatable = false)
    var actorId: Int? = null
    @field:Id
    @field:Column(name = "film_id", nullable = false, insertable = false, updatable = false)
    var filmId: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FilmActorPK

        if (actorId != other.actorId) return false
        if (filmId != other.filmId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = actorId ?: 0
        result = 31 * result + (filmId ?: 0)
        return result
    }
}