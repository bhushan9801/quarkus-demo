package com.helios.quarkus.demo.domain

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "film_category")
@IdClass(FilmCategoryPK::class)
open class FilmCategory {
    @field:Id
    @field:Column(name = "film_id", nullable = false, insertable = false, updatable = false)
    var filmId: Int? = null
    @field:Id
    @field:Column(name = "category_id", nullable = false, insertable = false, updatable = false)
    var categoryId: Int? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "film_id", referencedColumnName = "film_id")
    var film: Film? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "category_id", referencedColumnName = "category_id")
    var category: Category? = null

    override fun toString(): String =
        "Entity of type: ${javaClass.name} ( " +
            "filmId = $filmId " +
            "lastUpdate = $lastUpdate " +
            ")"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FilmCategory

        if (film != other.film) return false
        if (category != other.category) return false

        return true
    }

    override fun hashCode(): Int {
        var result = film?.hashCode() ?: 0
        result = 31 * result + (category?.hashCode() ?: 0)
        return result
    }

}

