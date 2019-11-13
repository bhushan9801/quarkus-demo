package com.helios.quarkus.demo.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "inventory")
open class Inventory {
    @field:Id
    @field:Column(name = "inventory_id", nullable = false, insertable = false, updatable = false)
    var inventoryId: Int? = null

    @field:Column(name = "film_id", nullable = false, insertable = false, updatable = false)
    var filmId: Int? = null

    @field:Column(name = "store_id", nullable = false, insertable = false, updatable = false)
    var storeId: Int? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "film_id", referencedColumnName = "film_id")
    var refFilm: Film? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "store_id", referencedColumnName = "store_id")
    var refStore: Store? = null
    @field:OneToMany(mappedBy = "refInventory", fetch = FetchType.LAZY)
    var refRentals = mutableListOf<Rental>()

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "inventoryId = $inventoryId " +
                    "filmId = $filmId " +
                    "storeId = $storeId " +
                    "lastUpdate = $lastUpdate " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Inventory

        if (inventoryId != other.inventoryId) return false
        if (filmId != other.filmId) return false
        if (storeId != other.storeId) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }

}

