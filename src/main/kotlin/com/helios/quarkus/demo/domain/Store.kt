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
@Table(name = "store")
open class Store {
    @field:Id
    @field:Column(name = "store_id", nullable = false, insertable = false, updatable = false)
    var storeId: Int? = null

    @field:Column(name = "manager_staff_id", nullable = false, insertable = false, updatable = false)
    var managerStaffId: Int? = null

    @field:Column(name = "address_id", nullable = false, insertable = false, updatable = false)
    var addressId: Int? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:OneToMany(mappedBy = "refStore", fetch = FetchType.LAZY)
    var refCustomers = mutableListOf<Customer>()
    @field:OneToMany(mappedBy = "refStore", fetch = FetchType.LAZY)
    var refInventories = mutableListOf<Inventory>()
    @field:OneToMany(mappedBy = "refStore", fetch = FetchType.LAZY)
    var refStaffs = mutableListOf<Staff>()
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id")
    var refStaff: Staff? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "address_id", referencedColumnName = "address_id")
    var refAddress: Address? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "storeId = $storeId " +
                    "managerStaffId = $managerStaffId " +
                    "addressId = $addressId " +
                    "lastUpdate = $lastUpdate " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Store

        if (storeId != other.storeId) return false
        if (managerStaffId != other.managerStaffId) return false
        if (addressId != other.addressId) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }

}

