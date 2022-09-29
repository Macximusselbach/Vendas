package br.com.dionataferraz.vendas.database.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.dionataferraz.vendas.database.local.entities.AccountEntity

@Dao
interface AccountDao {

    @Insert
    fun insertAccount(accountEntity: AccountEntity)

    @Query("SELECT * FROM accountTable")
    fun getAccounts(): List<AccountEntity>
}