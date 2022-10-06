package br.com.dionataferraz.vendas.database.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.dionataferraz.vendas.App
import br.com.dionataferraz.vendas.database.local.daos.AccountDao
import br.com.dionataferraz.vendas.database.local.daos.ProfileDao
import br.com.dionataferraz.vendas.database.local.daos.TransactionDao
import br.com.dionataferraz.vendas.database.local.entities.AccountEntity
import br.com.dionataferraz.vendas.database.local.entities.ProfileEntity
import br.com.dionataferraz.vendas.database.local.entities.TransactionEntity

@Database(entities = [ProfileEntity::class, AccountEntity::class, TransactionEntity::class], version = 1)
abstract class VendasDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDao
    abstract fun accountDao(): AccountDao
    abstract fun transactionDao(): TransactionDao

    companion object {
        fun getInstance(): VendasDatabase {
            return Room.databaseBuilder(App.context, VendasDatabase::class.java, "vendas.db").build()

        }
    }
}