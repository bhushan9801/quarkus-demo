package com.helios.quarkus.demo.dto


import java.time.Instant

class CustomerVO(var customerId: Long? = null,
                 var storeId: Long? = null,
                 var firstName: String? = null,
                 var lastName: String? = null,
                 var email: String? = null,
                 var addressId: Long? = null,
                 var activebool: String? = null,
                 var createDate: Instant? = null,
                 var lastUpdate: Instant? = null,
                 var active: Long? = null)
