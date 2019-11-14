package com.helios.quarkus.demo.dto


import java.time.Instant

class ActorVO(var actorId: Long? = null,
              var firstName: String? = null,
              var lastName: String? = null,
              var lastUpdate: Instant? = null)
