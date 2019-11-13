package com.helios.quarkus.demo.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class FilmActorPK : java.io.Serializable {
    @field:Column(name = "actor_id", nullable = false, insertable = false, updatable = false)
    var actorId: Short? = null
    @field:Column(name = "film_id", nullable = false, insertable = false, updatable = false)
    var filmId: Short? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as FilmActorPK

        if (actorId != other.actorId) return false
        if (filmId != other.filmId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}