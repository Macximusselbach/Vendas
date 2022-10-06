package br.com.dionataferraz.vendas.activities.profile.data.remote

import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.activities.profile.data.response.ProfileResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateProfileAPI {

    @POST("api/login")
    suspend fun createProfile(@Body profile: ProfileModel): ProfileResponse
}