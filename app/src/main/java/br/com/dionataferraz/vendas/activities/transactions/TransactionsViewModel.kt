package br.com.dionataferraz.vendas.activities.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class TransactionsViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val transactions: MutableLiveData<MutableList<TransactionModel>> = MutableLiveData()
    val showTransactions: LiveData<MutableList<TransactionModel>> = transactions

}