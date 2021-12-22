package com.first.quarkus.app.service

import com.first.quarkus.domain.entity.User
import com.first.quarkus.domain.repository.UserRepository
import com.first.quarkus.domain.service.UserService
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserServiceImp(
    private val userRepository: UserRepository
) : UserService {

    override fun create(user: User) = user.also(userRepository::persist)
}


