package br.com.dionataferraz.vendas.activities.balance.data.local

import br.com.dionataferraz.vendas.database.local.VendasDatabase

class BalanceLocalDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

}