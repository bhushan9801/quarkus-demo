package com.helios.quarkus.demo.domain

import io.ebean.Model
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "language", schema = "public", catalog = "imdb")
open class Language : Model() {
    @field:Id
    @field:Column(name = "language_id", nullable = false, insertable = false, updatable = false)
    var languageId: Int? = null
    @field:Basic
    @field:Column(name = "name", nullable = false)
    var name: String? = null
    @field:Basic
    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "languageId = $languageId " +
                    "name = $name " +
                    "lastUpdate = $lastUpdate " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Language

        if (languageId != other.languageId) return false
        if (name != other.name) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }

}

