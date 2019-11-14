package com.helios.quarkus.demo.dto

import java.time.Instant

data class PaymentVO(var paymentId: Long? = 0,
                     var customerId: Long? = 0,
                     var staffId: Long? = 0,
                     var rentalId: Long? = 0,
                     var amount: String? = null,
                     var paymentDate: Instant? = null) {
    constructor() : this(null, null, null, null, null, null)
}
