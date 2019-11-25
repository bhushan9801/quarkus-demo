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
@Table(name = "address")
open class Address {
    @field:Id
    @field:Column(name = "address_id", nullable = false, insertable = false, updatable = false)
    var addressId: Int? = null

    @field:Column(name = "address", nullable = false)
    var address: String? = null

    @field:Column(name = "address2", nullable = true)
    var address2: String? = null

    @field:Column(name = "district", nullable = false)
    var district: String? = null

    @field:Column(name = "city_id", nullable = false, insertable = false, updatable = false)
    var cityId: Int? = null

    @field:Column(name = "postal_code", nullable = true)
    var postalCode: String? = null

    @field:Column(name = "phone", nullable = false)
    var phone: String? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:ManyToOne(fetch = FetchType.LAZY, optional = false)
    @field:JoinColumn(name = "city_id", referencedColumnName = "city_id")
    var city: City? = null
    @field:OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    var customers = mutableListOf<Customer>()
    @field:OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    var staffs = mutableListOf<Staff>()
    @field:OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    var stores = mutableListOf<Store>()

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
            "addressId = $addressId " +
            "address = $address " +
            "address2 = $address2 " +
            "district = $district " +
            "cityId = $cityId " +
            "postalCode = $postalCode " +
            "phone = $phone " +
            "lastUpdate = $lastUpdate " +
            ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Address

        if (addressId != other.addressId) return false
        if (address != other.address) return false
        if (address2 != other.address2) return false
        if (district != other.district) return false
        if (cityId != other.cityId) return false
        if (postalCode != other.postalCode) return false
        if (phone != other.phone) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }

}

