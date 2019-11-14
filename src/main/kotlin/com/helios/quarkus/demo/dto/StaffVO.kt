package com.helios.quarkus.demo.dto


import java.time.Instant
import javax.json.bind.annotation.JsonbProperty

data class StaffVO(var staffId: Long? = null,
                   var firstName: String? = null,
                   var lastName: String? = null,
                   var addressId: Long? = null,
                   var email: String? = null,
                   var storeId: Long? = null,
                   var active: String? = null,
                   var username: String? = null,
                   var password: String? = null,
                   var lastUpdate: Instant? = null,
                   var picture: ByteArray? = null) {
    constructor() : this(null, null, null, null, null, null, null, null, null, null, null)

}
