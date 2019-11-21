package com.helios.quarkus.demo.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "payment")
open class Payment {
    @field:Id
    @field:Column(name = "payment_id", nullable = false)
    var paymentId: Int? = null

    @field:Column(name = "customer_id", nullable = false)
    var customerId: Int? = null

    @field:Column(name = "staff_id", nullable = false)
    var staffId: Int? = null

    @field:Column(name = "rental_id", nullable = false)
    var rentalId: Int? = null

    @field:Column(name = "amount", nullable = false, precision = 4, scale = 2)
    var amount: Double? = null

    @field:Column(name = "payment_date", nullable = false)
    var paymentDate: Instant? = null


    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
            "paymentId = $paymentId " +
            "customerId = $customerId " +
            "staffId = $staffId " +
            "rentalId = $rentalId " +
            "amount = $amount " +
            "paymentDate = $paymentDate " +
            ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Payment

        if (paymentId != other.paymentId) return false
        if (customerId != other.customerId) return false
        if (staffId != other.staffId) return false
        if (rentalId != other.rentalId) return false
        if (amount != other.amount) return false
        if (paymentDate != other.paymentDate) return false

        return true
    }

}

