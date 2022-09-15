package br.com.dionataferraz.vendas.activities.transactions

import java.util.Calendar


data class TransactionModel(
    val date : Calendar,
    val value : Double,
    val description : String,
    val place : Place,
)