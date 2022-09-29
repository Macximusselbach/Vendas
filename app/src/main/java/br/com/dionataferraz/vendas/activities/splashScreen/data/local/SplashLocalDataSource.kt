package br.com.dionataferraz.vendas.activities.splashScreen.data.local

import br.com.dionataferraz.vendas.database.local.VendasDatabase

class SplashLocalDataSource {

    private val database: VendasDatabase by lazy {
        VendasDatabase.getInstance()
    }

}