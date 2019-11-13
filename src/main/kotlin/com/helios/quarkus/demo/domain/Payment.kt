package com.helios.quarkus.demo.domain

import io.ebean.Model
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "payment", schema = "public", catalog = "imdb")
open class Payment : Model() {
    @field:Id
    @field:Column(name = "payment_id", nullable = false)
    var paymentId: Int? = null
    @field:Basic
    @field:Column(name = "customer_id", nullable = false)
    var customerId: Short? = null
    @field:Basic
    @field:Column(name = "staff_id", nullable = false)
    var staffId: Short? = null
    @field:Basic
    @field:Column(name = "rental_id", nullable = false)
    var rentalId: Int? = null
    @field:Basic
    @field:Column(name = "amount", nullable = false)
    var amount: java.math.BigDecimal? = null
    @field:Basic
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

