package br.com.dionataferraz.vendas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.transactions.domain.usecase.TransactionsUseCase
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val balance: MutableLiveData<Double> = MutableLiveData()
    val showBalance: LiveData<Double> = balance

    private val useCase by lazy {
        TransactionsUseCase()
    }

    fun getBalance() {
        viewModelScope.launch {
             useCase.getBalance()

//            if (balanceFromDb?.balance > 0) {
//                balance.value = balanceFromDb?.balance
//
//            } else {
//                balance.value = 0.00
//
//            }


        }
    }
}