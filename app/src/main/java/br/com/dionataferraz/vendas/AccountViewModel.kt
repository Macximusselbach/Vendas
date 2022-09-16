package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error
    private val accountModel: MutableLiveData<AccountModel> = MutableLiveData()
    val accountModelLiveData: LiveData<AccountModel> = accountModel

    fun createAccount(name: String?, balance: String, responsible: String?, type: String?) {

        if (name.isNullOrBlank()
            && balance.isNullOrBlank()
            && responsible.isNullOrBlank()
            && type.isNullOrBlank()
        ) {
            error.value = "Preencha todos os campos!"

        } else if (name.isNullOrBlank()) {
            error.value = "O campo nome é obrigatório!"

        } else if (balance.toString().isNullOrBlank()) {
            error.value = "O campo de saldo é obrigatório!"

        } else if (responsible.isNullOrBlank()) {
            error.value = "O campo responsável é obrigatório!"

        } else if (type.isNullOrBlank()) {
            error.value = "Defina um tipo de cartão!"

        } else {

            val account = AccountModel(
                accountName = name,
                balance = balance,
                responsible = responsible,
                accountType = type
            )

            accountModel.value = account

        }
    }
}