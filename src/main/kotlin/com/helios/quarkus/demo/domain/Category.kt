package com.helios.quarkus.demo.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "category")
open class Category {
    @field:Id
    @field:Column(name = "category_id", nullable = false, insertable = false, updatable = false)
    var categoryId: Int? = null

    @field:Column(name = "name", nullable = false)
    var name: String? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "categoryId = $categoryId " +
                    "name = $name " +
                    "lastUpdate = $lastUpdate " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Category

        if (categoryId != other.categoryId) return false
        if (name != other.name) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }

}

