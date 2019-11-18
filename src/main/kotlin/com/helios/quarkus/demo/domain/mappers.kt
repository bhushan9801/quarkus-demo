package com.helios.quarkus.demo.domain

import com.helios.quarkus.demo.dto.ActorVO
import com.helios.quarkus.demo.dto.FilmActorVO
import com.helios.quarkus.demo.dto.FilmVO
import com.helios.quarkus.demo.dto.StaffVO
import com.helios.quarkus.demo.dto.StoreVO
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "cdi")
interface Mappers {
    fun actorToVO(source: Actor?): ActorVO

    @Mapping(target = "password", ignore = true)
    fun staffToVo(source: Staff): StaffVO

    fun storeToVo(source: Store): StoreVO
    fun filmToVO(source: Film): FilmVO
    fun filmActorToVO(source: FilmActor): FilmActorVO

    @Mappings(
        Mapping(target = "firstName", source = "actor.firstName"),
        Mapping(target = "lastName", source = "actor.lastName"),
        Mapping(target = "lastUpdate", source = "actor.lastUpdate")
    )
    fun filmActorToActorVO(source: FilmActor): ActorVO
}