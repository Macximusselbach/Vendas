package br.com.dionataferraz.vendas.transactions.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balanceTable")
class BankBalanceEntity(
    @PrimaryKey
    val balance: Double
)