package br.com.dionataferraz.vendas.database.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accountTable")
data class AccountEntity(
    @PrimaryKey
    val accountName: String,
    val balance: Double,
    val responsible: String,
    val type: String
)