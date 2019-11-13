package com.helios.quarkus.demo.domain

import io.ebean.Model
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "address", schema = "public", catalog = "imdb")
open class Address : Model() {
    @field:Id
    @field:Column(name = "address_id", nullable = false, insertable = false, updatable = false)
    var addressId: Int? = null
    @field:Basic
    @field:Column(name = "address", nullable = false)
    var address: String? = null
    @field:Basic
    @field:Column(name = "address2", nullable = true)
    var address2: String? = null
    @field:Basic
    @field:Column(name = "district", nullable = false)
    var district: String? = null
    @field:Basic
    @field:Column(name = "city_id", nullable = false, insertable = false, updatable = false)
    var cityId: Short? = null
    @field:Basic
    @field:Column(name = "postal_code", nullable = true)
    var postalCode: String? = null
    @field:Basic
    @field:Column(name = "phone", nullable = false)
    var phone: String? = null
    @field:Basic
    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "city_id", referencedColumnName = "city_id")
    var refCity: City? = null
    @field:OneToMany(mappedBy = "refAddress")
    var refCustomers: List<Customer>? = null
    @field:OneToMany(mappedBy = "refAddress")
    var refStaffs: List<Staff>? = null
    @field:OneToMany(mappedBy = "refAddress")
    var refStores: List<Store>? = null

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

