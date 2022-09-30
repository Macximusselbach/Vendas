package br.com.dionataferraz.vendas.transactions.data.repository

import android.util.Log
import br.com.dionataferraz.vendas.transactions.BankBalanceModel
import br.com.dionataferraz.vendas.transactions.TransactionModel
import br.com.dionataferraz.vendas.transactions.data.local.ErrorModel
import br.com.dionataferraz.vendas.transactions.data.local.Result
import br.com.dionataferraz.vendas.transactions.data.local.TransactionLocalDataSource

class TransactionRepository {

    private val localDataSource by lazy {
        TransactionLocalDataSource()
    }

    suspend fun insertInitialValue(balance: BankBalanceModel) {
        localDataSource.insertInitialValue(balance = balance)

    }

    suspend fun getBalance(): Result<BankBalanceModel, ErrorModel> {
        return localDataSource.getBalance()

    }

    suspend fun deposit(value: Double, date: String): Result<TransactionModel, ErrorModel> {
        return localDataSource.deposit(value = value, date = date)

    }

    suspend fun withdraw(value: Double, date: String): Result<TransactionModel, ErrorModel> {
        return localDataSource.withdraw(value = value, date = date)

    }

    suspend fun getTransactions(): Result<MutableList<TransactionModel>, ErrorModel> {
        return localDataSource.getTransactions()

    }


}