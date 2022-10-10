package br.com.dionataferraz.vendas.activities.splashScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.activities.profile.domain.useCase.ProfileUseCase
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    private val useCase by lazy {
        ProfileUseCase()
    }

    private val existsUser: MutableLiveData<Boolean> = MutableLiveData(false)
    val shouldGoHome: LiveData<Boolean> = existsUser

    fun checkExistsProfile() {
        Log.e("Salvo no local (splash)", "chechExistsProfile")
        viewModelScope.launch {
            val savedProfile = useCase.getProfileFromLocalDb()
            Log.e("Salvo no local (splash)", savedProfile.get().toString())
            existsUser.value = savedProfile.get() != null


        }

    }
}