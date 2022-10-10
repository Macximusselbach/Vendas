package br.com.dionataferraz.vendas.activities.transactions.data.remote

import br.com.dionataferraz.vendas.activities.transactions.TransactionModel
import br.com.dionataferraz.vendas.activities.transactions.data.response.TransactionResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface TransactionsAPI {

    @POST("api/transaction")
    suspend fun createTransaction(@Body transaction: TransactionModel): TransactionResponse

    @GET("api/transaction")
    suspend fun getTransactions(@Path("userId") userid: Int): List<TransactionResponse>
}