package com.first.quarkus.domain.repository

import com.first.quarkus.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
