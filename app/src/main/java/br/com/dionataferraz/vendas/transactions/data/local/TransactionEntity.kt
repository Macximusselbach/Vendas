package br.com.dionataferraz.vendas.transactions.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionTable")
data class TransactionEntity(
    val operation: String,
    val value: Double,
    @PrimaryKey
    val date: String
)