package com.helios.quarkus.demo.dto


import java.time.Instant

class FilmCategoryVO(var filmId: Long? = null,
                     var categoryId: Long? = null,
                     var lastUpdate: Instant? = null)
