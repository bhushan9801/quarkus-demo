package com.helios.quarkus.demo.domain

import com.helios.quarkus.demo.types.TsVectorType
import com.vladmihalcea.hibernate.type.array.StringArrayType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import java.time.Instant
import java.time.Year
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "film")
@TypeDefs(
        TypeDef(name = "string-array", typeClass = StringArrayType::class),
        TypeDef(name = "tsvector", typeClass = TsVectorType::class)
)
open class Film {
    @field:Id
    @field:Column(name = "film_id", nullable = false, insertable = false, updatable = false)
    var filmId: Int? = null

    @field:Column(name = "title", nullable = false)
    var title: String? = null

    @field:Column(name = "description", nullable = true)
    var description: String? = null

    @field:Column(name = "release_year", nullable = true)
    var releaseYear: Int? = null

    @field:Column(name = "language_id", nullable = false, insertable = false, updatable = false)
    var languageId: Int? = null

    @field:Column(name = "original_language_id", nullable = true, insertable = false, updatable = false)
    var originalLanguageId: Int? = null

    @field:Column(name = "rental_duration", nullable = false)
    var rentalDuration: Int? = null

    @field:Column(name = "rental_rate", nullable = false)
    var rentalRate: java.math.BigDecimal? = null

    @field:Column(name = "length", nullable = true)
    var length: Int? = null

    @field:Column(name = "replacement_cost", nullable = false)
    var replacementCost: java.math.BigDecimal? = null

    @field:Column(name = "rating", nullable = true)
    var rating: String? = null

    @field:Column(name = "last_update", nullable = false)
    var lastUpdate: Instant? = null

    @field:Column(name = "special_features", nullable = true, columnDefinition = "text[]")
    @field:Type(type = "string-array")
    var specialFeatures: Array<String>? = null

    @field:Column(name = "fulltext", nullable = false)
    @field:Type(type = "tsvector")
    var fulltext: String? = null

    @field:ManyToOne(fetch = FetchType.LAZY, optional = false)
    @field:JoinColumn(name = "language_id", referencedColumnName = "language_id")
    var refLanguage: Language? = null
    @field:ManyToOne(fetch = FetchType.LAZY, optional = false)
    @field:JoinColumn(name = "original_language_id", referencedColumnName = "language_id")
    var orgLanguage: Language? = null
    @field:OneToMany(mappedBy = "refFilm", fetch = FetchType.LAZY)
    var refFilmActors = mutableListOf<FilmActor>()
    @field:OneToMany(mappedBy = "refFilm", fetch = FetchType.LAZY)
    var refFilmCategories = mutableListOf<FilmCategory>()
    @field:OneToMany(mappedBy = "refFilm", fetch = FetchType.LAZY)
    var refInventories = mutableListOf<Inventory>()

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Film

        if (filmId != other.filmId) return false

        return true
    }

    override fun hashCode(): Int {
        return filmId ?: 0
    }
}

