package br.com.dionataferraz.vendas.activities.transactions.data.remote

import android.util.Log
import br.com.dionataferraz.vendas.activities.transactions.TransactionModel
import br.com.dionataferraz.vendas.activities.transactions.TransactionPlace
import br.com.dionataferraz.vendas.activities.transactions.data.response.TransactionResponse
import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result
import br.com.dionataferraz.vendas.database.remote.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransactionRemoteDataSource {

    private val service = RetrofitNetworkClient.createNetworkClient().create(TransactionsAPI::class.java)

    suspend fun createTransaction(userId: Int, transaction: TransactionModel): Result<TransactionModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                service.createTransaction(userId, transaction)

                Result.Success(transaction)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }
    }

    suspend fun getTransactions(userId: Int): Result<List<TransactionModel>, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val transactionsListResponse = service.getTransactions(userId)
                Log.e("pegou na api", transactionsListResponse.toString())
                val transactionsListModel = convertResponseListToModel(transactionsListResponse)
                Result.Success(transactionsListModel)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }
    }

    private fun convertResponseListToModel(transactionsToConvert: List<TransactionResponse>): List<TransactionModel> {
        val convertedItems = mutableListOf<TransactionModel>()

        transactionsToConvert.forEach { transaction ->
            convertedItems.add(
                TransactionModel(
                    transaction.value,
                    checkPlace(transaction.transactionType),
                    transaction.description
                )
            )
        }

        return convertedItems.toList()

    }

    private fun checkPlace(place: String): TransactionPlace {
        when (place) {
            "PUB" -> return TransactionPlace.PUB
            "MARKET" -> return TransactionPlace.MARKET
            "GAS_STATION" -> return TransactionPlace.GAS_STATION
        }

        return TransactionPlace.PUB
    }

}