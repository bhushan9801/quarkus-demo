package com.helios.quarkus.demo.dto


import java.time.Instant

data class StoreVO(var storeId: Long? = 0,
                   var managerStaffId: Long? = 0,
                   var addressId: Long? = 0,
                   var lastUpdate: Instant? = null) {
    constructor() : this(null, null, null, null)

}
