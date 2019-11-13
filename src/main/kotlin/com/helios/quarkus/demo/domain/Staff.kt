package com.helios.quarkus.demo.domain

import io.ebean.Model
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "staff", schema = "public", catalog = "imdb")
open class Staff : Model() {
    @field:Id
    @field:Column(name = "staff_id", nullable = false, insertable = false, updatable = false)
    var staffId: Int? = null
    @field:Basic
    @field:Column(name = "first_name", nullable = false)
    var firstName: String? = null
    @field:Basic
    @field:Column(name = "last_name", nullable = false)
    var lastName: String? = null
    @field:Basic
    @field:Column(name = "address_id", nullable = false, insertable = false, updatable = false)
    var addressId: Short? = null
    @field:Basic
    @field:Column(name = "email", nullable = true)
    var email: String? = null
    @field:Basic
    @field:Column(name = "store_id", nullable = false, insertable = false, updatable = false)
    var storeId: Short? = null
    @field:Basic
    @field:Column(name = "active", nullable = false)
    var active: Boolean? = null
    @field:Basic
    @field:Column(name = "username", nullable = false)
    var username: String? = null
    @field:Basic
    @field:Column(name = "password", nullable = true)
    var password: String? = null
    @field:Basic
    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null
    @field:Basic
    @field:Column(name = "picture", nullable = true)
    var picture: ByteArray? = null

    @field:OneToMany(mappedBy = "refStaff")
    var refRentals: List<Rental>? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "address_id", referencedColumnName = "address_id")
    var refAddress: Address? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "store_id", referencedColumnName = "store_id")
    var refStore: Store? = null
    @field:OneToMany(mappedBy = "refStaff")
    var refStores: List<Store>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "staffId = $staffId " +
                    "firstName = $firstName " +
                    "lastName = $lastName " +
                    "addressId = $addressId " +
                    "email = $email " +
                    "storeId = $storeId " +
                    "active = $active " +
                    "username = $username " +
                    "password = $password " +
                    "lastUpdate = $lastUpdate " +
                    "picture = $picture " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Staff

        if (staffId != other.staffId) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (addressId != other.addressId) return false
        if (email != other.email) return false
        if (storeId != other.storeId) return false
        if (active != other.active) return false
        if (username != other.username) return false
        if (password != other.password) return false
        if (lastUpdate != other.lastUpdate) return false
        if (picture != other.picture) return false

        return true
    }

}

