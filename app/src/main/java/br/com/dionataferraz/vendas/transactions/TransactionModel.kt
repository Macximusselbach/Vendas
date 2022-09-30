package br.com.dionataferraz.vendas.transactions

data class TransactionModel(
    val operation: String,
    val value: Double,
    val date: String
)