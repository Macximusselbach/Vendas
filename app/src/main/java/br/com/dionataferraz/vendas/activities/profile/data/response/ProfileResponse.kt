package br.com.dionataferraz.vendas.activities.profile.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
)