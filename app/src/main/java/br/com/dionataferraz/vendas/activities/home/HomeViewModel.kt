package br.com.dionataferraz.vendas.activities.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.UserIdTest
import br.com.dionataferraz.vendas.activities.transactions.domain.usecase.TransactionUseCase
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val money: MutableLiveData<String> = MutableLiveData()
    val showMoney: LiveData<String> = money

    private val transactionsUseCase by lazy {
        TransactionUseCase()

    }

    fun sumMoney() {
        viewModelScope.launch {
            val userId = UserIdTest.id
            val transactions = transactionsUseCase.getTransactions(userId)

            var total = 0.0
            fun Double.formats(qtd: Int) = "%.${qtd}f".format(this)

            transactions.get()?.forEach { transaction ->
                total += transaction.value

            }

            money.value = "R$${total.formats(2)}"
        }
    }
}