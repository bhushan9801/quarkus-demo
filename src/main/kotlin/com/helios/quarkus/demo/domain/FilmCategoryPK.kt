package com.helios.quarkus.demo.domain

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
open class FilmCategoryPK : java.io.Serializable {
    @field:Column(name = "film_id", nullable = false, insertable = false, updatable = false)
    var filmId: Short? = null
    @field:Column(name = "category_id", nullable = false, insertable = false, updatable = false)
    var categoryId: Short? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as FilmCategoryPK

        if (filmId != other.filmId) return false
        if (categoryId != other.categoryId) return false

        return true
    }

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

}