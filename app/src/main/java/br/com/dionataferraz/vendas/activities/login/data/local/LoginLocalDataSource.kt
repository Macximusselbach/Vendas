package br.com.dionataferraz.vendas.activities.login.data.local

import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result
import br.com.dionataferraz.vendas.database.local.VendasDatabase

class LoginLocalDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

//    fun login(email: String?, password: String?): Result<LoginUserResponse, ErrorModel> {
//
//
//    }
}