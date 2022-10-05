package br.com.dionataferraz.vendas.transactions

import android.util.Log
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

    fun deposit(inputedValue: String, date: String) {

        viewModelScope.launch {

            if (inputedValue.isNullOrEmpty()) {
                error.value = "Insira o valor!"

            } else {
                val value = inputedValue.toDouble()

                if (value <= 0) {
                    error.value = "Insira o valor!"

                } else {
                    useCase.deposit(value, date)
                    error.value = "Operação bem sucedida!"

                }

            }
        }
    }

    fun withdraw(inputedValue: String, date: String) {

        viewModelScope.launch {

            if (inputedValue.isNullOrEmpty()) {
                error.value = "Insira o valor!"

            } else {
                val currentBalance = useCase.getBalance().get()?.balance
                val value = inputedValue.toDouble()

                if (value <= 0) {
                    error.value = "Insira o valor!"

                } else if (value > currentBalance!!) {
                    error.value = "Valor maior que o saldo atual!"

                } else {
                    useCase.withdraw(value, date)
                    error.value = "Operação bem sucedida!"

                }
            }

        }
    }
}
