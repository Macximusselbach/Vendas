package br.com.dionataferraz.vendas.login.data.response

data class LoginUserResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)