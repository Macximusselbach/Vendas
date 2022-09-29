package br.com.dionataferraz.vendas.activities.balance.data.repository

import br.com.dionataferraz.vendas.activities.balance.data.local.BalanceLocalDataSource

class BalanceRepository {

    private val localDataSource by lazy {
        BalanceLocalDataSource()
    }

}