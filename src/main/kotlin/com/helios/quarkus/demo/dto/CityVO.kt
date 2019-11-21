package com.helios.quarkus.demo.dto


import java.time.Instant

class CityVO(var cityId: Long? = null,
             var city: String? = null,
             var countryId: Long? = null,
             var lastUpdate: Instant? = null)
