package br.com.dionataferraz.vendas.activities.transactions

import java.util.*


data class TransactionModel(
    val date : Date,
    val value : Double,
    val description : String,
    val place : TransactionPlace,
)