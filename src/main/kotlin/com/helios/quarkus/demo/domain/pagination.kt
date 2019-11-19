package com.helios.quarkus.demo.domain

import java.io.Serializable
import java.lang.IllegalArgumentException
import javax.validation.constraints.Min
import javax.ws.rs.DefaultValue
import javax.ws.rs.QueryParam

class Page() {

    companion object {
        const val DEFAULT_PAGE = 1
        const val DEFAULT_SIZE = 20
        const val DEFAULT_ORDER_BY = "+lastUpdate"
    }

    @QueryParam(value = "page")
    @DefaultValue(DEFAULT_PAGE.toString())
    @Min(1, message = "Page number cannot be below 1")
    var pageNumber: Int = DEFAULT_PAGE
    @QueryParam("size")
    @DefaultValue(DEFAULT_SIZE.toString())
    var size: Int = DEFAULT_SIZE
    @QueryParam("order")
    @DefaultValue(DEFAULT_ORDER_BY)
    var orderBy: String = DEFAULT_ORDER_BY

    fun offset(): Int {
        if (pageNumber > 0)
            return ((pageNumber - 1) * size)
        else
            throw IllegalArgumentException("Page number cannot be less than 1")
    }

    fun sortSpec() = Sort(orderBy)
}

class Sort(private val fieldSpec: String) {

    fun field(): String = trimOrdering()

    fun ordering(): Order = when (fieldSpec.get(0)) {
        '+' -> Order.ASC
        '-' -> Order.DESC
        else -> Order.ASC
    }

    private fun trimOrdering(): String {
        return fieldSpec.trimStart('+', '-')
    }

    enum class Order {
        ASC, DESC
    }
}

data class PagedResult<T>(val data: List<T>, val total: Long, val page: Page) : Serializable