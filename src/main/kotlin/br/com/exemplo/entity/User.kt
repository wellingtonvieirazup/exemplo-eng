package br.com.exemplo.entity

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class User(
    val id: UUID?,
    val login: String?,
    val password: String?
)