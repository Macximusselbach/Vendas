package br.com.dionataferraz.vendas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.transactions.domain.usecase.TransactionsUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val balance: MutableLiveData<String> = MutableLiveData()
    val showBalance: LiveData<String> = balance

    private val useCase by lazy {
        TransactionsUseCase()
    }

    fun getBalance() {
        viewModelScope.launch {
            val balanceFromDb = useCase.getBalance()

            if (balanceFromDb.get()?.balance.toString()
                    .isNullOrEmpty() || balanceFromDb.get()?.balance!! <= 0
            ) {
                balance.value = "0.00"

            } else {
                balance.value = balanceFromDb.get()?.balance.toString()


            }

        }
    }
}