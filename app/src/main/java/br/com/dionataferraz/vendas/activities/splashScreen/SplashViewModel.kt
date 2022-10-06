package br.com.dionataferraz.vendas.activities.splashScreen

import androidx.lifecycle.ViewModel
import br.com.dionataferraz.vendas.activities.login.domain.useCase.LoginUseCase

class SplashViewModel: ViewModel() {

    private val useCase by lazy {
        LoginUseCase()
    }
}