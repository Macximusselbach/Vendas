package br.com.dionataferraz.vendas.login.data.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.dionataferraz.vendas.App
import br.com.dionataferraz.vendas.transactions.data.local.BankBalanceDao
import br.com.dionataferraz.vendas.transactions.data.local.BankBalanceEntity
import br.com.dionataferraz.vendas.transactions.data.local.TransactionDao
import br.com.dionataferraz.vendas.transactions.data.local.TransactionEntity

@Database(entities = arrayOf(UserEntity::class, TransactionEntity::class, BankBalanceEntity::class), version = 1)
abstract class VendasDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun transactionDao(): TransactionDao
    abstract fun bankBalanceDao(): BankBalanceDao

    companion object {
        fun getInstance(): VendasDatabase {
            return Room.databaseBuilder(
                App.context,
                VendasDatabase::class.java,
                "vendas.db"
            ).build()
        }
    }
}