package br.com.dionataferraz.vendas.activities.account.data.repository

import br.com.dionataferraz.vendas.activities.account.data.local.AccountLocalDataSource

class AccountRepository {

    private val localDataSource by lazy {
        AccountLocalDataSource()
    }


}