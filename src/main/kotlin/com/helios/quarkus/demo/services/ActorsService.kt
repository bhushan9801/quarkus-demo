package com.helios.quarkus.demo.services

import com.helios.quarkus.demo.domain.Actor
import com.helios.quarkus.demo.domain.Mappers
import com.helios.quarkus.demo.dto.ActorVO
import javax.inject.Singleton
import javax.persistence.EntityManager

@Singleton
class ActorsService(em: EntityManager, val mappers: Mappers) : BaseService<Actor, ActorVO>(em, Actor::class.java) {

    override fun convert(source: Actor): ActorVO = mappers.actorToVO(source)
}