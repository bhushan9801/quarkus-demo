package com.helios.quarkus.demo.dto


import java.time.Instant

class CountryVO(var countryId: Long? = null,
                var country: String? = null,
                var lastUpdate: Instant? = null)
