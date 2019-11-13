package com.helios.quarkus.demo.domain

import javax.persistence.Column
import javax.persistence.Id

open class FilmCategoryPK : java.io.Serializable {
    @field:Id
    @field:Column(name = "film_id", nullable = false, insertable = false, updatable = false)
    var filmId: Int? = null
    @field:Id
    @field:Column(name = "category_id", nullable = false, insertable = false, updatable = false)
    var categoryId: Int? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FilmCategoryPK

        if (filmId != other.filmId) return false
        if (categoryId != other.categoryId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = filmId ?: 0
        result = 31 * result + (categoryId ?: 0)
        return result
    }
}