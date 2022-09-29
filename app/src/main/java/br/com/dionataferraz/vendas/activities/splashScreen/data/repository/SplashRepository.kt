package br.com.dionataferraz.vendas.activities.splashScreen.data.repository

import br.com.dionataferraz.vendas.activities.splashScreen.data.local.SplashLocalDataSource

class SplashRepository {

    private val localDataSource by lazy {
        SplashLocalDataSource()

    }

}