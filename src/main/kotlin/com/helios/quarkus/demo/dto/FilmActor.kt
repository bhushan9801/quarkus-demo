package com.helios.quarkus.demo.dto


import java.time.Instant

class FilmActor(var actorId: Long? = null,
                var filmId: Long? = null,
                var lastUpdate: Instant? = null)
