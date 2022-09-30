package br.com.dionataferraz.vendas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.transactions.BankBalanceModel
import br.com.dionataferraz.vendas.transactions.domain.usecase.TransactionsUseCase
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val useCase by lazy {
        TransactionsUseCase()
    }

    fun creteTestBalance() {
        viewModelScope.launch {
            useCase.insertInitialValue(BankBalanceModel(0.00))

        }

    }


}