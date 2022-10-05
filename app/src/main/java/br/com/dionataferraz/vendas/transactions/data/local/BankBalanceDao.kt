package br.com.dionataferraz.vendas.transactions.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface BankBalanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTestValue(bankBalanceEntity: BankBalanceEntity)

    @Query("UPDATE balanceTable SET balance = :newBalance")
    fun updateBalance(newBalance: Double)

    @Query("SELECT balance FROM balanceTable")
    fun getBalance(): BankBalanceEntity

}