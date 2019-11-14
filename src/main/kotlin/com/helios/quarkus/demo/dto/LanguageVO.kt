package com.helios.quarkus.demo.dto


import java.time.Instant

data class LanguageVO(var languageId: Long? = 0,
                      var name: String? = null,
                      var lastUpdate: Instant? = null) {
    constructor() : this(null, null, null)
}
