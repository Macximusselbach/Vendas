package br.com.dionataferraz.vendas.activities.home.data.repository

import br.com.dionataferraz.vendas.activities.home.data.local.HomeLocalDataSource

class HomeRepository {

    private val localDataSource by lazy {
        HomeLocalDataSource()
    }

}