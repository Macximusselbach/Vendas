package br.com.dionataferraz.vendas.transactions.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface BankBalanceDao {

    @Insert
    fun insertTestValue(bankBalanceEntity: BankBalanceEntity)

    @Update(entity = BankBalanceEntity::class)
    fun updateBalance(newBalance: BankBalanceEntity)

    @Query("SELECT * FROM balanceTable")
    fun getBalance(): BankBalanceEntity

}