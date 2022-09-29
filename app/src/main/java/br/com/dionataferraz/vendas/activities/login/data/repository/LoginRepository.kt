package br.com.dionataferraz.vendas.activities.login.data.repository

import br.com.dionataferraz.vendas.activities.login.data.local.LoginLocalDataSource
import br.com.dionataferraz.vendas.login.data.remote.ErrorModel
import br.com.dionataferraz.vendas.login.data.remote.LoginRemoteDataSource
import br.com.dionataferraz.vendas.login.data.remote.Result
import br.com.dionataferraz.vendas.login.data.response.UserResponse

class LoginRepository {

    private val localDataSource by lazy {
        LoginLocalDataSource()
    }

    suspend fun login(email: String, password: String) : String {
         localDataSource.login(email = email, password = password)
        return "a"
    }


}