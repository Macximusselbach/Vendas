package br.com.dionataferraz.vendas.login.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginUserResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)