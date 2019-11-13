package com.helios.quarkus.demo

import io.agroal.api.AgroalDataSource
import io.ebean.EbeanServerFactory
import io.ebean.config.ServerConfig
import io.quarkus.runtime.StartupEvent
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.context.Dependent
import javax.enterprise.event.Observes
import javax.sql.CommonDataSource

@ApplicationScoped
open class AppStartup(val dataSource: AgroalDataSource) {

    open fun onStart(@Observes env: StartupEvent) {
        val config = ServerConfig()
        config.name = "pagila"
        config.dataSource = dataSource
        config.isUseJtaTransactionManager = true
        config.isDefaultServer = true
        EbeanServerFactory.create(config);
    }
}