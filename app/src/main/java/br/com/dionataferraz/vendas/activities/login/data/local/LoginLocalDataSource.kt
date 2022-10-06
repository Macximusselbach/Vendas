package br.com.dionataferraz.vendas.activities.login.data.local

import br.com.dionataferraz.vendas.database.local.VendasDatabase
import br.com.dionataferraz.vendas.login.data.remote.ErrorModel
import br.com.dionataferraz.vendas.login.data.remote.Result
import br.com.dionataferraz.vendas.login.data.response.LoginUserResponse

class LoginLocalDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

//    fun login(email: String?, password: String?): Result<LoginUserResponse, ErrorModel> {
//
//
//    }
}