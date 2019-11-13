package com.helios.quarkus.demo.domain

import io.ebean.Model
import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "country", schema = "public", catalog = "imdb")
open class Country : Model() {
    @field:Id
    @field:Column(name = "country_id", nullable = false, insertable = false, updatable = false)
    var countryId: Int? = null
    @field:Basic
    @field:Column(name = "country", nullable = false)
    var country: String? = null
    @field:Basic
    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:OneToMany(mappedBy = "refCountry")
    var refCities: List<City>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "countryId = $countryId " +
                    "country = $country " +
                    "lastUpdate = $lastUpdate " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Country

        if (countryId != other.countryId) return false
        if (country != other.country) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }

}

