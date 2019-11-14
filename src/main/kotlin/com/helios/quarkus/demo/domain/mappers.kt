package com.helios.quarkus.demo.domain

import com.helios.quarkus.demo.dto.ActorVO
import com.helios.quarkus.demo.dto.StaffVO
import com.helios.quarkus.demo.dto.StoreVO
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "cdi")
interface Mappers {
    fun actorToVO(source: Actor): ActorVO

    @Mapping(target = "password", ignore = true)
    fun staffToVo(source: Staff): StaffVO

    fun storeToVo(source: Store): StoreVO
}