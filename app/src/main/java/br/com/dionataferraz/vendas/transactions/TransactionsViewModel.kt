package br.com.dionataferraz.vendas.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.transactions.domain.usecase.TransactionsUseCase
import kotlinx.coroutines.launch

class TransactionsViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val transactions: MutableLiveData<MutableList<TransactionModel>> = MutableLiveData()
    val showTransactions: LiveData<MutableList<TransactionModel>> = transactions

    private val useCase by lazy {
        TransactionsUseCase()
    }

    fun getTransactions() {
        viewModelScope.launch {
            val transactionsFromDb = useCase.getTransactions()

            if (transactionsFromDb.get() != null) {
                transactions.value = transactionsFromDb.get()

            } else {
                error.value = "Erro ao carregar as transações."

            }
        }
    }



}