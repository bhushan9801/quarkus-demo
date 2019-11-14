package com.helios.quarkus.demo.dto


import java.time.Instant

class CategoryVO(var categoryId: Long? = null,
                 var name: String? = null,
                 var lastUpdate: Instant? = null)
