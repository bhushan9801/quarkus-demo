package com.helios.quarkus.demo.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "actor")
open class Actor {
    @field:Id
    @field:Column(name = "actor_id", nullable = false, insertable = false, updatable = false)
    var actorId: Int? = null

    @field:Column(name = "first_name", nullable = false)
    var firstName: String? = null

    @field:Column(name = "last_name", nullable = false)
    var lastName: String? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "actorId = $actorId " +
                    "firstName = $firstName " +
                    "lastName = $lastName " +
                    "lastUpdate = $lastUpdate " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Actor

        if (actorId != other.actorId) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }
}

