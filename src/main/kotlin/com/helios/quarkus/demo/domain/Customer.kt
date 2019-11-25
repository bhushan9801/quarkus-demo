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
@Table(name = "customer")
open class Customer {
    @field:Id
    @field:Column(name = "customer_id", nullable = false, insertable = false, updatable = false)
    var customerId: Int? = null

    @field:Column(name = "store_id", nullable = false, insertable = false, updatable = false)
    var storeId: Int? = null

    @field:Column(name = "first_name", nullable = false)
    var firstName: String? = null

    @field:Column(name = "last_name", nullable = false)
    var lastName: String? = null

    @field:Column(name = "email", nullable = true)
    var email: String? = null

    @field:Column(name = "address_id", nullable = false, insertable = false, updatable = false)
    var addressId: Int? = null

    @field:Column(name = "activebool", nullable = false)
    var activebool: Boolean? = null

    @field:Column(name = "create_date", nullable = false)
    var createDate: java.sql.Date? = null

    @field:Column(name = "last_update", nullable = true)
    var lastUpdate: Instant? = null

    @field:Column(name = "active", nullable = true)
    var active: Int? = null

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "store_id", referencedColumnName = "store_id")
    var store: Store? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "address_id", referencedColumnName = "address_id")
    var address: Address? = null
    @field:OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    var rentals = mutableListOf<Rental>()

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
            "customerId = $customerId " +
            "storeId = $storeId " +
            "firstName = $firstName " +
            "lastName = $lastName " +
            "email = $email " +
            "addressId = $addressId " +
            "activebool = $activebool " +
            "createDate = $createDate " +
            "lastUpdate = $lastUpdate " +
            "active = $active " +
            ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Customer

        if (customerId != other.customerId) return false
        if (storeId != other.storeId) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (email != other.email) return false
        if (addressId != other.addressId) return false
        if (activebool != other.activebool) return false
        if (createDate != other.createDate) return false
        if (lastUpdate != other.lastUpdate) return false
        if (active != other.active) return false

        return true
    }

}

