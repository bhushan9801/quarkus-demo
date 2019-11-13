package com.helios.quarkus.demo.types

import com.vladmihalcea.hibernate.type.ImmutableType
import com.vladmihalcea.hibernate.type.util.ReflectionUtils
import org.hibernate.engine.spi.SharedSessionContractImplementor
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Types

class TsVectorType : ImmutableType<String>(String::class.java) {
    override fun get(rs: ResultSet?, names: Array<String>?, sesion: SharedSessionContractImplementor?, owner: Any?): String? {
        val ip = rs?.getString(names?.get(0))
        return ip
    }

    override fun set(ps: PreparedStatement?, value: String?, index: Int, session: SharedSessionContractImplementor?) {
        if (value == null)
            ps?.setNull(index, Types.OTHER)
        else {
            val instance = ReflectionUtils.newInstance<Unit?>("org.postgresql.util.PGobject")
            ReflectionUtils.invokeSetter(instance, "type", "tsvector")
            ReflectionUtils.invokeSetter(instance, "value", value)
            ps?.setObject(index, instance)
        }
    }

    override fun sqlTypes(): IntArray? {
        return intArrayOf(Types.OTHER)
    }
}