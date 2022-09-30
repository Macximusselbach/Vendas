package br.com.dionataferraz.vendas.transactions.domain.usecase

import android.util.Log
import br.com.dionataferraz.vendas.transactions.BankBalanceModel
import br.com.dionataferraz.vendas.transactions.TransactionModel
import br.com.dionataferraz.vendas.transactions.data.local.ErrorModel
import br.com.dionataferraz.vendas.transactions.data.local.Result
import br.com.dionataferraz.vendas.transactions.data.repository.TransactionRepository

class TransactionsUseCase {

    private val repository by lazy {
        TransactionRepository()

    }

    suspend fun insertInitialValue(balance: BankBalanceModel) {
        repository.insertInitialValue(balance = balance)

    }

    suspend fun getBalance(): Result<BankBalanceModel, ErrorModel> {
        return repository.getBalance()

    }

    suspend fun deposit(value: Double, date: String): Result<TransactionModel, ErrorModel> {
        return repository.deposit(value = value, date = date)

    }

    suspend fun withdraw(value: Double, date: String): Result<TransactionModel, ErrorModel> {
        return repository.withdraw(value = value, date = date)

    }

    suspend fun getTransactions(): Result<MutableList<TransactionModel>, ErrorModel> {
        return repository.getTransactions()

    }


}