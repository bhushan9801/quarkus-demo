package com.helios.quarkus.demo.dto


import java.time.Instant

data class RentalVO(var rentalId: Long? = 0,
                    var rentalDate: Instant? = null,
                    var inventoryId: Long? = 0,
                    var customerId: Long? = 0,
                    var returnDate: Instant? = null,
                    var staffId: Long? = 0,
                    var lastUpdate: Instant? = null) {
    constructor() : this(null, null, null, null, null, null, null)

}
