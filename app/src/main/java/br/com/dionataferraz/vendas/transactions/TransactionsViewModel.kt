package br.com.dionataferraz.vendas.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.transactions.domain.usecase.TransactionsUseCase
import kotlinx.coroutines.launch

class TransactionsViewModel: ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val useCase by lazy {
        TransactionsUseCase()
    }

    fun deposit(value: Double?) {
        viewModelScope.launch {
            if (value != null && value > 0) {

            }
        }
    }
}