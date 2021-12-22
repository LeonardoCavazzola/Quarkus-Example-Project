package com.first.quarkus.domain.repository

import com.first.quarkus.domain.entity.User
import io.quarkus.hibernate.orm.panache.PanacheRepository

interface UserRepository : PanacheRepository<User>
