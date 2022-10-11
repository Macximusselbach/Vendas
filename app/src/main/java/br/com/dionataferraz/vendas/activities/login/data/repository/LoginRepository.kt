package br.com.dionataferraz.vendas.activities.login.data.repository

import android.util.Log
import br.com.dionataferraz.vendas.activities.profile.data.local.ProfileLocalDataSource
import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result
import br.com.dionataferraz.vendas.login.data.remote.LoginRemoteDataSource
import br.com.dionataferraz.vendas.login.data.response.LoginUserResponse

class LoginRepository {

    private val profileLocalDataSource by lazy {
       ProfileLocalDataSource()
    }

    private val remoteDataSource by lazy {
        LoginRemoteDataSource()
    }

    suspend fun login(email: String, password: String): Result<LoginUserResponse, ErrorModel> {
        val response = remoteDataSource.login(email = email, password = password)
        val profileEntity = profileLocalDataSource.convertResponseToEntity(response.get()!!)
        profileLocalDataSource.createProfile(profileEntity)

        return response
    }



}