package br.com.dionataferraz.vendas.transactions.data.local

import android.util.Log
import br.com.dionataferraz.vendas.login.data.local.VendasDatabase
import br.com.dionataferraz.vendas.transactions.BankBalanceModel
import br.com.dionataferraz.vendas.transactions.TransactionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransactionLocalDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun insertInitialValue(balance: BankBalanceModel) {

        return withContext(Dispatchers.IO) {
            val balanceToInsert = convertBalanceToEntity(balance)
            database.bankBalanceDao().insertTestValue(balanceToInsert)

        }

    }

    suspend fun getBalance(): Result<BankBalanceModel, ErrorModel> {

        return withContext(Dispatchers.IO) {
            try {
                Log.e("------------", "ffgf" + database.bankBalanceDao().getBalance().balance.toString())
                val balanceFromDb = database.bankBalanceDao().getBalance()
                val convertedBalance = convertBalanceToModel(balanceFromDb)

                Result.Success(convertedBalance)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }

    }

    suspend fun deposit(value: Double, date: String): Result<TransactionModel, ErrorModel> {

        return withContext(Dispatchers.IO) {
            try {
                val currentBalance = database.bankBalanceDao().getBalance()
                val newBalance = BankBalanceEntity(currentBalance.balance - value)

                database.bankBalanceDao().updateBalance(newBalance)
                database.transactionDao().saveTransaction(TransactionEntity("Deposit", value, date))

                val transaction = TransactionModel("Deposit", value, date)
                Result.Success(transaction)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }
    }

    suspend fun withdraw(value: Double, date: String): Result<TransactionModel, ErrorModel> {

        return withContext(Dispatchers.IO) {
            try {
                val currentBalance = database.bankBalanceDao().getBalance()
                val newBalance = BankBalanceEntity(currentBalance.balance - value)

                database.bankBalanceDao().updateBalance(newBalance)
                database.transactionDao().saveTransaction(TransactionEntity("Withdraw", value, date))

                val transaction = TransactionModel("Withdraw", value, date)
                Result.Success(transaction)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }
    }

    suspend fun getTransactions(): Result<MutableList<TransactionModel>, ErrorModel> {

        return withContext(Dispatchers.IO) {
            try {
                val transactionsFromDb = database.transactionDao().getTransactions()
                val convertedTransactions = convertTransactionsToModel(transactionsFromDb)

                Result.Success(convertedTransactions)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)
            }
        }
    }

    private fun convertTransactionsToModel(itemsToConvert: List<TransactionEntity>): MutableList<TransactionModel> {
        val convertedItems = mutableListOf<TransactionModel>()

        itemsToConvert.forEach {transaction ->
            convertedItems.add(
                TransactionModel(
                transaction.operation,
                transaction.value,
                transaction.date)
            )
        }

        return convertedItems
    }

    private fun convertBalanceToEntity(balanceToConvert: BankBalanceModel): BankBalanceEntity {
        return BankBalanceEntity(balanceToConvert.balance)

    }

    private fun convertBalanceToModel(balanceToConvert: BankBalanceEntity): BankBalanceModel {
        return BankBalanceModel(balanceToConvert.balance)

    }


}

object ErrorModel

sealed class Result<out S, out E> {
    data class Success<S>(val value: S) : Result<S, Nothing>()
    data class Error<E>(val value: E) : Result<Nothing, E>()

    fun get(): S? {
        return when (this) {
            is Success -> value
            else -> null
        }
    }
}