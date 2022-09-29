package br.com.dionataferraz.vendas.activities.account.data.local

import br.com.dionataferraz.vendas.database.local.VendasDatabase

class AccountLocalDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

}