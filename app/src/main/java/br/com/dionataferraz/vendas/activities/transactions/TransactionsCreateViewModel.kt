package br.com.dionataferraz.vendas.activities.transactions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.UserIdTest
import br.com.dionataferraz.vendas.activities.transactions.domain.usecase.TransactionUseCase
import kotlinx.coroutines.launch

class TransactionsCreateViewModel: ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val home: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldShowHome: LiveData<Boolean> = home

    private val useCase by lazy {
        TransactionUseCase()

    }

    fun createTransaction(value: String, place: String, description: String) {
        viewModelScope.launch {
            val transaction = TransactionModel(value.toDouble(), checkPlace(place), description)
            val userIdTest = UserIdTest.id

            val savedTransaction = useCase.createTransaction(userIdTest, transaction)

            if (savedTransaction.get() != null) {
                home.value = true

            } else {
                error.value = "Preencha todos os campos!"

            }

        }
    }

    private fun checkPlace(place: String): TransactionPlace {
        when (place) {
            "MARKET" -> return TransactionPlace.MARKET
            "GAS_STATION"  -> return TransactionPlace.GAS_STATION
            "PUB" -> return TransactionPlace.PUB

        }

        return TransactionPlace.PUB
    }
}