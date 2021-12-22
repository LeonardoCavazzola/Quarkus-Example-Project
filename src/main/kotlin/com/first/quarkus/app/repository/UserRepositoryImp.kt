package com.first.quarkus.app.repository

import com.first.quarkus.domain.repository.UserRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepositoryImp : UserRepository
