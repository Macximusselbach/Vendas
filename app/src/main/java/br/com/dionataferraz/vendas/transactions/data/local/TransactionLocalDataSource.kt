package br.com.dionataferraz.vendas.transactions.data.local

import br.com.dionataferraz.vendas.login.data.local.VendasDatabase

class TransactionLocalDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

}