package br.com.dionataferraz.vendas.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.transactions.domain.usecase.TransactionsUseCase
import kotlinx.coroutines.launch

class ModifyBalanceViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val useCase by lazy {
        TransactionsUseCase()
    }

    fun deposit(inputedValue: String?, date: String) {
        val value = inputedValue?.toDouble()

        viewModelScope.launch {
            if (value != null && value > 0) {
                useCase.deposit(value, date)

            } else if (value == null || value <= 0) {
                error.value = "Insira o valor!"

            }
        }
    }

    fun withdraw(inputedValue: String?, date: String) {
        viewModelScope.launch {
            val currentBalance = useCase.getBalance().get()?.balance
            val value = inputedValue?.toDouble()

            if (value != null && value > 0) {

                if (value < currentBalance!!){
                    useCase.withdraw(value, date)

                } else {
                    error.value = "Valor maior que o saldo atual!"

                }


            } else if (value == null || value <= 0) {
                error.value = "Insira o valor!"

            }
        }
    }

}
