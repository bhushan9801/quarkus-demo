package com.helios.quarkus.demo.domain

import io.ebean.Model
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "rental", schema = "public", catalog = "imdb")
open class Rental : Model() {
    @field:Id
    @field:Column(name = "rental_id", nullable = false, insertable = false, updatable = false)
    var rentalId: Int? = null
    @field:Basic
    @field:Column(name = "rental_date", nullable = false)
    var rentalDate: Instant? = null
    @field:Basic
    @field:Column(name = "inventory_id", nullable = false, insertable = false, updatable = false)
    var inventoryId: Int? = null
    @field:Basic
    @field:Column(name = "customer_id", nullable = false, insertable = false, updatable = false)
    var customerId: Short? = null
    @field:Basic
    @field:Column(name = "return_date", nullable = true)
    var returnDate: Instant? = null
    @field:Basic
    @field:Column(name = "staff_id", nullable = false, insertable = false, updatable = false)
    var staffId: Short? = null
    @field:Basic
    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id")
    var refInventory: Inventory? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    var refCustomer: Customer? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
    var refStaff: Staff? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "rentalId = $rentalId " +
                    "rentalDate = $rentalDate " +
                    "inventoryId = $inventoryId " +
                    "customerId = $customerId " +
                    "returnDate = $returnDate " +
                    "staffId = $staffId " +
                    "lastUpdate = $lastUpdate " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Rental

        if (rentalId != other.rentalId) return false
        if (rentalDate != other.rentalDate) return false
        if (inventoryId != other.inventoryId) return false
        if (customerId != other.customerId) return false
        if (returnDate != other.returnDate) return false
        if (staffId != other.staffId) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }

}

