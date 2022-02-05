package com.first.quarkus.app.repository

import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepositoryBase

fun <Entity : Any, Id : Any> PanacheRepositoryBase<Entity, Id>.mergeAndReturn(entity: Entity): Entity {
    return this.getEntityManager().merge(entity)
}

fun <Entity : Any, Id : Any> PanacheRepositoryBase<Entity, Id>.persistAndReturn(entity: Entity): Entity {
    return entity.also { this.persist(entity) }
}
