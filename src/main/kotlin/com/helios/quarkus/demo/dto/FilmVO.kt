package com.helios.quarkus.demo.dto


import java.time.Instant

class FilmVO(var filmId: Long? = null,
             var title: String? = null,
             var description: String? = null,
             var releaseYear: String? = null,
             var languageId: Long? = null,
             var originalLanguageId: Long? = null,
             var rentalDuration: Long? = null,
             var rentalRate: String? = null,
             var length: Long? = null,
             var replacementCost: String? = null,
             var rating: String? = null,
             var lastUpdate: Instant? = null,
             var specialFeatures: Array<String>? = null,
             var fulltext: String? = null)
