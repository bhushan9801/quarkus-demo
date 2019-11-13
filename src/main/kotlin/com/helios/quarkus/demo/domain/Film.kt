package com.helios.quarkus.demo.domain

import io.ebean.Model
import java.time.Instant
import java.time.Year
import javax.persistence.*

@Entity
@Table(name = "film", schema = "public", catalog = "imdb")
open class Film : Model() {
    @field:Id
    @field:Column(name = "film_id", nullable = false, insertable = false, updatable = false)
    var filmId: Int? = null
    @field:Basic
    @field:Column(name = "title", nullable = false)
    var title: String? = null
    @field:Basic
    @field:Column(name = "description", nullable = true)
    var description: String? = null
    @field:Basic
    @field:Column(name = "release_year", nullable = true)
    var releaseYear: Year? = null
    @field:Basic
    @field:Column(name = "language_id", nullable = false, insertable = false, updatable = false)
    var languageId: Short? = null
    @field:Basic
    @field:Column(name = "original_language_id", nullable = true, insertable = false, updatable = false)
    var originalLanguageId: Short? = null
    @field:Basic
    @field:Column(name = "rental_duration", nullable = false)
    var rentalDuration: Short? = null
    @field:Basic
    @field:Column(name = "rental_rate", nullable = false)
    var rentalRate: java.math.BigDecimal? = null
    @field:Basic
    @field:Column(name = "length", nullable = true)
    var length: Short? = null
    @field:Basic
    @field:Column(name = "replacement_cost", nullable = false)
    var replacementCost: java.math.BigDecimal? = null
    @field:Basic
    @field:Column(name = "rating", nullable = true)
    var rating: String? = null
    @field:Basic
    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null
    @field:Basic
    @field:Column(name = "special_features", nullable = true)
    var specialFeatures: String? = null
    @field:Basic
    @field:Column(name = "fulltext", nullable = false)
    var fulltext: String? = null

    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "language_id", referencedColumnName = "language_id")
    var refLanguage: Language? = null
    @field:ManyToOne(fetch = FetchType.LAZY)
    @field:JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    var orgLanguage: Language? = null
    @field:OneToMany(mappedBy = "refFilm")
    var refFilmActors: List<FilmActor>? = null
    @field:OneToMany(mappedBy = "refFilm")
    var refFilmCategories: List<FilmCategory>? = null
    @field:OneToMany(mappedBy = "refFilm")
    var refInventories: List<Inventory>? = null

    override fun toString(): String =
            "Entity of type: ${javaClass.name} ( " +
                    "filmId = $filmId " +
                    "title = $title " +
                    "description = $description " +
                    "releaseYear = $releaseYear " +
                    "languageId = $languageId " +
                    "originalLanguageId = $originalLanguageId " +
                    "rentalDuration = $rentalDuration " +
                    "rentalRate = $rentalRate " +
                    "length = $length " +
                    "replacementCost = $replacementCost " +
                    "rating = $rating " +
                    "lastUpdate = $lastUpdate " +
                    "specialFeatures = $specialFeatures " +
                    "fulltext = $fulltext " +
                    ")"

    // constant value returned to avoid entity inequality to itself before and after it's update/merge
    override fun hashCode(): Int = 42

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Film

        if (filmId != other.filmId) return false
        if (title != other.title) return false
        if (description != other.description) return false
        if (releaseYear != other.releaseYear) return false
        if (languageId != other.languageId) return false
        if (originalLanguageId != other.originalLanguageId) return false
        if (rentalDuration != other.rentalDuration) return false
        if (rentalRate != other.rentalRate) return false
        if (length != other.length) return false
        if (replacementCost != other.replacementCost) return false
        if (rating != other.rating) return false
        if (lastUpdate != other.lastUpdate) return false
        if (specialFeatures != other.specialFeatures) return false
        if (fulltext != other.fulltext) return false

        return true
    }

}

