package br.com.dionataferraz.vendas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val home: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldShowHome: LiveData<Boolean> = home

    fun login(email: String?, password: String?) {

        val loginEmail = "teste@gmail.com"
        val loginPassword = "12345"


        if (email.isNullOrBlank() && password.isNullOrBlank()) {
            error.value = "Preencha os campos"

        } else if(email != loginEmail && password != loginPassword) {
            error.value = "Credenciais inválidas"

        } else if(email.equals(loginEmail) && password.equals(loginPassword)) {
            home.value = true

        }
    }

}