package br.com.dionataferraz.vendas.database.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userTable")
data class ProfileEntity(
    @PrimaryKey
    val id : Int,
    val name: String,
    val email: String,
    val password: String,
)
