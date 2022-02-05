package com.first.quarkus.app.service

import com.first.quarkus.app.repository.persistAndReturn
import com.first.quarkus.app.repository.mergeAndReturn
import com.first.quarkus.app.repository.UserRepository
import com.first.quarkus.domain.entity.User
import com.first.quarkus.domain.service.UserService
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserServiceImp(
    private val userRepository: UserRepository
) : UserService {
    override fun findOneById(id: Long): User? = userRepository.findById(id)
    override fun findAll(): List<User> = userRepository.listAll()
    override fun create(user: User): User = userRepository.persistAndReturn(user)
    override fun update(user: User): User = userRepository.mergeAndReturn(user)
}
