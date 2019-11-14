package com.helios.quarkus.demo.domain

import javax.ws.rs.DefaultValue
import javax.ws.rs.QueryParam

class Page() {

    companion object {
        const val DEFAULT_PAGE = 0
        const val DEFAULT_SIZE = 20
        const val DEFAULT_ORDER_BY = "+lastUpdate"
    }

    constructor(page: Int, size: Int, orderBy: String) : this() {
        this.pageNumber = page
        this.size = size
        this.orderBy = orderBy
    }

    @QueryParam(value = "page")
    @DefaultValue(DEFAULT_PAGE.toString())
    var pageNumber: Int = DEFAULT_PAGE
    @QueryParam("size")
    @DefaultValue(DEFAULT_SIZE.toString())
    var size: Int = DEFAULT_SIZE
    @QueryParam("order")
    @DefaultValue(DEFAULT_ORDER_BY)
    var orderBy: String = DEFAULT_ORDER_BY

    fun offset(): Int = (pageNumber * size)

    fun sortSpec() = Sort(orderBy)
}

class Sort(private val fieldSpec: String) {

    fun field(): String = trimOrdering()

    fun ordering(): Order = when (fieldSpec.get(0)) {
        '+' -> Order.ASC
        '-' -> Order.DESC
        else -> Order.ASC
    }

    fun trimOrdering(): String {
        return fieldSpec.trimStart('+', '-')
    }

    enum class Order {
        ASC, DESC
    }
}

