package br.com.dionataferraz.vendas.database.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionTable")
data class TransactionEntity(
    val operation: String,
    val value: Double,
    @PrimaryKey
    val date: String
)