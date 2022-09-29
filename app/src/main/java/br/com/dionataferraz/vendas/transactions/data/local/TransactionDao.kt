package br.com.dionataferraz.vendas.transactions.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TransactionDao {

    @Insert
    fun insertTransaction(transactionEntity: TransactionEntity)

    @Query("SELECT * FROM transactionTable")
    fun getTransaction(): List<TransactionEntity>
}