package br.com.exemplo.service

import br.com.exemplo.entity.User
import br.com.exemplo.repository.UserRepository
import javax.inject.Singleton

@Singleton
class UserServiceImpl(private val userRepository: UserRepository): UserService {
    override fun getAll(): List<User> {
        return userRepository.getUser()
    }

    override fun getById(id: String): User? {
        return userRepository.getByIdUser(id)
    }
}