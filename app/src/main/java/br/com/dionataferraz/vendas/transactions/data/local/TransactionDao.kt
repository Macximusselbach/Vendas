package br.com.dionataferraz.vendas.transactions.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TransactionDao {

    @Insert
    fun saveTransaction(transactionEntity: TransactionEntity)

    @Query("SELECT * FROM transactionTable ORDER BY date DESC")
    fun getTransactions(): List<TransactionEntity>
}