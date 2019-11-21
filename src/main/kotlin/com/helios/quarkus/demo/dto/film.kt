package com.helios.quarkus.demo.dto


import java.time.Instant

class FilmVO(var filmId: Long? = null,
             var title: String? = null,
             var description: String? = null,
             var releaseYear: String? = null,
             var languageName: String? = null,
             var orgLanguageName: String? = null,
             var rentalDuration: Long? = null,
             var rentalRate: Double? = null,
             var length: Long? = null,
             var replacementCost: Double? = null,
             var rating: String? = null,
             var lastUpdate: Instant? = null,
             var specialFeatures: Array<String>? = null,
             var fulltext: String? = null,
             var filmActors: List<ActorVO>? = null)

class FilmInfoVO(var filmId: Long? = null,
                 var title: String? = null,
                 var description: String? = null,
                 var releaseYear: String? = null,
                 var languageName: String? = null,
                 var orgLanguageName: String? = null,
                 var rentalDuration: Long? = null,
                 var rentalRate: String? = null,
                 var length: Long? = null,
                 var replacementCost: String? = null,
                 var rating: String? = null,
                 var lastUpdate: Instant? = null,
                 var specialFeatures: Array<String>? = null,
                 var fulltext: String? = null)
