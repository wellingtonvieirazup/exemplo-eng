package br.com.exemplo.controller

import br.com.exemplo.entity.User
import br.com.exemplo.service.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller("/usuario")
class UserController(private val userService: UserService) {
    @Get
    fun getAll(): HttpResponse<List<User>> {
        val listUser = this.userService.getAll()
        return HttpResponse.ok(listUser).body(this.userService.getAll())
    }

    @Get("/{id}")
    fun getGetId(@PathVariable id: String): HttpResponse<Any> {
        val user = this.userService.getById(id)
        return HttpResponse.ok(user)
    }
}