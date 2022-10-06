package br.com.dionataferraz.vendas.login.data.remote

import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result
import br.com.dionataferraz.vendas.database.remote.RetrofitNetworkClient
import br.com.dionataferraz.vendas.login.data.response.LoginUserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginRemoteDataSource {

    private val service = RetrofitNetworkClient.createNetworkClient().create(LoginAPI::class.java)

    suspend fun login(email: String, password: String): Result<LoginUserResponse, ErrorModel> {
        return withContext(Dispatchers.IO){
            try {
                val user = service.login(email, password)
                Result.Sucesss(user)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }
    }
}
