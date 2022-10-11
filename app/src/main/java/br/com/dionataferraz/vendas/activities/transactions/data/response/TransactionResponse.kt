package br.com.dionataferraz.vendas.activities.transactions.data.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransactionResponse(
    val id: Int,
    val value: Double,
    val transactionType: String,
    val description: String
)