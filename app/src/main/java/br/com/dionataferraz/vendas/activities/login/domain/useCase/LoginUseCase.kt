package br.com.dionataferraz.vendas.activities.login.domain.useCase

import br.com.dionataferraz.vendas.activities.login.data.repository.LoginRepository
import br.com.dionataferraz.vendas.login.data.remote.ErrorModel
import br.com.dionataferraz.vendas.login.data.remote.Result
import br.com.dionataferraz.vendas.login.data.response.LoginUserResponse

class LoginUseCase {

    private val repository by lazy {
        LoginRepository()
    }

    suspend fun login(email: String, password: String) : Result<LoginUserResponse, ErrorModel> {
        return repository.login(email = email, password = password)
    }

}