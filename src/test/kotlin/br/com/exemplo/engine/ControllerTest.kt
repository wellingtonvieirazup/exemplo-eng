package br.com.exemplo.engine

import br.com.exemplo.controller.UserController
import br.com.exemplo.entity.User
import br.com.exemplo.service.UserService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class ControllerTest : AnnotationSpec() {

    val userService = mockk<UserService>()

    val userController = UserController(userService)

    lateinit var user: User

    @BeforeEach
    fun setup(){
        user = User(UUID.fromString("6d74801d-edba-4276-bb80-c329160a6b2e"), "vieira@live.com","123456")
    }

    @Test
    fun `getId register with success`(){

        every { userService.getById("6d74801d-edba-4276-bb80-c329160a6b2e") } returns user

        val result = userController.getGetId("6d74801d-edba-4276-bb80-c329160a6b2e")

        result.status shouldBe HttpStatus.OK
    }

    @Test
    fun `getAll register with success`(){

        val list = listOf(user)

        every { userService.getAll() } returns list

        val result = userController.getAll()

        result.body() shouldBe list
    }



}