package br.com.dionataferraz.vendas.login.data.remote

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

object ErrorModel
sealed class Result<out S, out E> {
    data class Sucesss<S>(val value: S): Result<S, Nothing>()
    data class Error<E>(val value: E): Result<Nothing, E>()

    fun get():S? {
        return when(this) {
            is Sucesss -> value
            else -> null
        }
    }
}