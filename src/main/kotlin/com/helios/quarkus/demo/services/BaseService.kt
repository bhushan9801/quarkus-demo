package com.helios.quarkus.demo.services

import com.helios.quarkus.demo.domain.Page
import com.helios.quarkus.demo.domain.Sort
import javax.persistence.EntityManager
import javax.persistence.TypedQuery
import javax.persistence.criteria.Path

abstract class BaseService<T, V>(private val em: EntityManager, private val clazz: Class<T>) {

    fun get(id: Long): V {
        return convert(em.find(clazz, id))
    }

    fun list(page: Page): List<V> {
        val query = buildCriteriaQuery(page)
        return convertList(buildCriteriaQuery(page).resultList)
    }

    protected fun buildCriteriaQuery(page: Page): TypedQuery<T> {
        val cb = em.criteriaBuilder
        val query = cb.createQuery(clazz)
        val root = query.from(clazz)
        query.select(root)
        val sort = page.sortSpec()
        val field: Path<Any> = root.get(sort.field())
        val orderBy = if (sort.ordering() == Sort.Order.ASC) {
            cb.asc(field)
        } else {
            cb.desc(field)
        };
        query.orderBy(orderBy)
        val tQuery = em.createQuery(query)
        tQuery.firstResult = page.offset()
        tQuery.maxResults = page.size
        return tQuery
    }

    protected fun convertList(source: List<T>): List<V> {
        val list = mutableListOf<V>()
        source.forEach { list.add(convert(it)) }
        return list
    }

    protected abstract fun convert(source: T): V
}