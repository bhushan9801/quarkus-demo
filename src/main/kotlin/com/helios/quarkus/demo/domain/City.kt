package com.helios.quarkus.demo.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "city")
open class City {
    @field:Id
    @field:Column(name = "city_id", nullable = false, insertable = false, updatable = false)
    var cityId: Int? = null

    @field:Column(name = "city", nullable = false)
    var city: String? = null

    @field:Column(name = "country_id", nullable = false, insertable = false, updatable = false)
    var countryId: Int? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "country_id", referencedColumnName = "country_id")
    var refCountry: Country? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "cityId = $cityId " +
                    "city = $city " +
                    "countryId = $countryId " +
                    "lastUpdate = $lastUpdate " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as City

        if (cityId != other.cityId) return false
        if (city != other.city) return false
        if (countryId != other.countryId) return false
        if (lastUpdate != other.lastUpdate) return false

        return true
    }

}

