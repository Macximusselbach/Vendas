package br.com.dionataferraz.vendas.activities.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.activities.login.domain.useCase.LoginUseCase
import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val useCase by lazy {
        LoginUseCase()
    }

    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error

    private val home: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldGoHome: LiveData<Boolean> = home

    suspend fun login(email: String?, password: String?) {
        viewModelScope.launch {

            if (email.isNullOrEmpty()) {
                error.value = "Credenciais inválidas!"

            } else if (password.isNullOrEmpty()) {
                error.value = "Credenciais inválidas!"

            } else {
                val user = useCase.login(email, password)

                if (user.get() != null) {
                    home.value = true

                } else {
                    error.value = "Credenciais inválidas!"

                }
            }
        }

    }
}
