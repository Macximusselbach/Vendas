package br.com.dionataferraz.vendas.database.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.dionataferraz.vendas.database.local.entities.TransactionEntity

@Dao
interface TransactionDao {

    @Insert
    fun insertTransaction(transactionEntity: TransactionEntity)

    @Query("SELECT * FROM transactionTable")
    fun getTransactions(): List<TransactionEntity>
}