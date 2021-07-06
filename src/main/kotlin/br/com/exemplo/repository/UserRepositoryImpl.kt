package br.com.exemplo.repository

import br.com.exemplo.entity.User
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl(private val session: CqlSession): UserRepository {

    override fun getUser(): List<User> {
        val results = session.execute("SELECT * from exemplo.User")
        val res = results.map {
            User(
                it.getUuid("id"), it.getString("login").orEmpty(), it.getString("password").orEmpty()
            )
        }
        return res.toList()
    }

    override fun getByIdUser(id: String): User? {
        val temporaryId = UUID.fromString(id)
        val results = session.execute(
            SimpleStatement.newInstance("SELECT * FROM exemplo.User WHERE id = ? LIMIT 10000", temporaryId)
        )
        return results.map { User -> User(
        User.getUuid("id")!!, User.getString("login"), User.getString("password")
        ) }.first()
    }

}