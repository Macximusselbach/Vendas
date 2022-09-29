package br.com.dionataferraz.vendas.transactions.data.repository

import br.com.dionataferraz.vendas.transactions.data.local.TransactionLocalDataSource

class TransactionRepository {

    private val localDataSource by lazy {
        TransactionLocalDataSource()
    }

}