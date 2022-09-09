package br.com.dionataferraz.vendas.activities.account

data class AccountModel(
    val accountName: String,
    val balance: Number,
    val responsible: String,
    val accountType: String
)