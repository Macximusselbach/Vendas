package br.com.dionataferraz.vendas.activities.transactions

data class TransactionModel(
    val value : Double,
    val place : TransactionPlace,
    val description : String
)