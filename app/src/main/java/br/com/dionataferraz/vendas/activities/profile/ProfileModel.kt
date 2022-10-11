package br.com.dionataferraz.vendas.activities.profile

data class ProfileModel(
    val name: String,
    val email: String,
    val password: String
) {
    val id: Int = 0
}