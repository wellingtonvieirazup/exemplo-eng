package br.com.exemplo.repository

import br.com.exemplo.entity.User
import java.util.*
import javax.inject.Singleton

@Singleton
interface UserRepository {
    fun getUser(): List<User>
    fun getByIdUser(id: String): User?

}
