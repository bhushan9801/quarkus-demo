package com.helios.quarkus.demo.domain

import java.time.Instant
import javax.persistence.Cacheable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "language")
@Cacheable
open class Language {
    @field:Id
    @field:Column(name = "language_id", nullable = false, insertable = false, updatable = false)
    var languageId: Int? = null

    @field:Column(name = "name", nullable = false)
    var name: String? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
            "languageId = $languageId " +
            "name = $name " +
            "lastUpdate = $lastUpdate " +
            ")"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Language

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name?.hashCode() ?: 0
    }
}

