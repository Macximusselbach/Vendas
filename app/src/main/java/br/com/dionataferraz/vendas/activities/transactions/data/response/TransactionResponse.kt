package br.com.dionataferraz.vendas.activities.transactions.data.response

data class TransactionResponse(
    val id: Int,
    val value: Double,
    val place: String,
    val description: String
)