package br.com.dionataferraz.vendas.activities.transactions

data class TransactionModel(
    val value : Double,
    val transactionType : TransactionPlace,
    val description : String
) {
    val id: Int = 0
}