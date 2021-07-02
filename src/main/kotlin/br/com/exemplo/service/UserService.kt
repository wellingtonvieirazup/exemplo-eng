package br.com.exemplo.service

import br.com.exemplo.entity.User
import javax.inject.Singleton

@Singleton
interface UserService {
    fun getAll(): List<User>
    fun getById(id: String): User?

}
