package br.com.dionataferraz.vendas.activities.transactions.domain.usecase

import br.com.dionataferraz.vendas.activities.transactions.TransactionModel
import br.com.dionataferraz.vendas.activities.transactions.data.repository.TransactionRepository
import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result

class TransactionUseCase {

    private val repository by lazy {
        TransactionRepository()

    }

    suspend fun createTransaction(userId: Int, transaction: TransactionModel): Result<TransactionModel, ErrorModel> {
        return repository.createTransaction(userId, transaction,)

    }

    suspend fun getTransactions(userId: Int): Result<List<TransactionModel>, ErrorModel> {
        return repository.getTransactions(userId)

    }
}