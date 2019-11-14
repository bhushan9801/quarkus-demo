package com.helios.quarkus.demo.dto


import java.time.Instant

class InventoryVO(var inventoryId: Long? = null,
                  var filmId: Long? = null,
                  var storeId: Long? = null,
                  var lastUpdate: Instant? = null)
