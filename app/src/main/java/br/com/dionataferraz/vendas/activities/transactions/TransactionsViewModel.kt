package br.com.dionataferraz.vendas.activities.transactions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.UserIdTest
import br.com.dionataferraz.vendas.activities.profile.domain.useCase.ProfileUseCase
import br.com.dionataferraz.vendas.activities.transactions.domain.usecase.TransactionUseCase
import kotlinx.coroutines.launch


class TransactionsViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val transactionsDb: MutableLiveData<MutableList<TransactionModel>> = MutableLiveData()
    val showTransactions: LiveData<MutableList<TransactionModel>> = transactionsDb

    private val transactionUseCase by lazy {
        TransactionUseCase()

    }

    private val profileUseCase by lazy {
        ProfileUseCase()

    }

    fun getTransactions() {

        viewModelScope.launch {
           // val userId = profileUseCase.getProfileFromLocalDb().get()?.id
            val userIdTest = UserIdTest.id
            val transactions = transactionUseCase.getTransactions(userIdTest)
            Log.e("transactions da api", transactions.get().toString())

            if (transactions.get() != null) {
                transactionsDb.value = transactions.get()!!.toMutableList()

            } else {
                error.value = "Erro ao carregar as transações."

            }
        }
    }

}