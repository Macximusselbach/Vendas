package br.com.dionataferraz.vendas

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
            val balanceFromDb = useCase.getBalance().get()?.balance

            if (balanceFromDb == null) {
                balance.value = "Problemas ao carregar informações!"

            } else {
                fun Double.formats(qtd: Int) = "%.${qtd}f".format(this)
                balance.value = "R$ ${balanceFromDb.formats(2)}"

            }

        }
    }
}