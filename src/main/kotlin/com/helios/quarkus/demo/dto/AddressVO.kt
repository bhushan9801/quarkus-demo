package com.helios.quarkus.demo.dto


import java.time.Instant

class AddressVO(var addressId: Long? = null,
                var address: String? = null,
                var address2: String? = null,
                var district: String? = null,
                var cityId: Long? = null,
                var postalCode: String? = null,
                var phone: String? = null,
                var lastUpdate: Instant? = null)
