package br.com.dionataferraz.vendas.login.data.remote

import br.com.dionataferraz.vendas.login.data.response.LoginUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginAPI {

    @GET("api/login")
    suspend fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): LoginUserResponse
}