package com.helios.quarkus.demo.domain

import io.ebean.Model
import java.time.Instant
import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "film_actor", schema = "public", catalog = "imdb")
open class FilmActor : Model() {
    @field:EmbeddedId
    var id: FilmActorPK? = null
    @field:Basic
    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    var refActor: Actor? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "film_id", referencedColumnName = "film_id")
    var refFilm: Film? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "actorId = $id " +
                    "lastUpdate = $lastUpdate " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as FilmActor

        if (id != other.id) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }

}

