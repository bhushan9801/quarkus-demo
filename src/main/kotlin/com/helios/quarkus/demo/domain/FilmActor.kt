package com.helios.quarkus.demo.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "film_actor")
@IdClass(FilmActorPK::class)
open class FilmActor {
    @field:Id
    @field:Column(name = "actor_id", nullable = false, insertable = false, updatable = false)
    var actorId: Int? = null
    @field:Id
    @field:Column(name = "film_id", nullable = false, insertable = false, updatable = false)
    var filmId: Int? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    var actor: Actor? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "film_id", referencedColumnName = "film_id")
    var film: Film? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
            "actorId = $actorId " +
            "lastUpdate = $lastUpdate " +
            ")"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FilmActor

        if (actor != other.actor) return false
        if (film != other.film) return false

        return true
    }

    override fun hashCode(): Int {
        var result = actor?.hashCode() ?: 0
        result = 31 * result + (film?.hashCode() ?: 0)
        return result
    }

}

