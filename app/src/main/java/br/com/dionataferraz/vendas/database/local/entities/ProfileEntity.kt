package br.com.dionataferraz.vendas.database.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class ProfileEntity(
    val name: String,
    @PrimaryKey
    val email: String,
    val password: String,
)
