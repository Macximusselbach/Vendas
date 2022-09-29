package br.com.dionataferraz.vendas.activities.home.data.local

import br.com.dionataferraz.vendas.database.local.VendasDatabase

class HomeLocalDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

}