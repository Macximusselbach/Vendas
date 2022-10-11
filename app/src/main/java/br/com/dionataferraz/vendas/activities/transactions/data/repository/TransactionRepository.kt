package br.com.dionataferraz.vendas.activities.transactions.data.repository

import br.com.dionataferraz.vendas.activities.transactions.TransactionModel
import br.com.dionataferraz.vendas.activities.transactions.data.remote.TransactionRemoteDataSource
import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result

class TransactionRepository {

    private val dataSource by lazy {
        TransactionRemoteDataSource()

    }

    suspend fun createTransaction(userId: Int, transaction: TransactionModel): Result<TransactionModel, ErrorModel> {
        return dataSource.createTransaction(userId, transaction)

    }

    suspend fun getTransactions(userId: Int): Result<List<TransactionModel>, ErrorModel> {
        return dataSource.getTransactions(userId)

    }


}