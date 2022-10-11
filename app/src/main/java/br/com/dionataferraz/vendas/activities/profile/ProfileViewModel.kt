package br.com.dionataferraz.vendas.activities.profile


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dionataferraz.vendas.activities.profile.domain.useCase.ProfileUseCase
import kotlinx.coroutines.launch


class ProfileViewModel : ViewModel() {

    private val useCase by lazy {
        ProfileUseCase()
    }


    private val error: MutableLiveData<String> = MutableLiveData()
    val shouldShowError: LiveData<String> = error
    private val sucess: MutableLiveData<Boolean> = MutableLiveData(false)
    val successSave: LiveData<Boolean> = sucess

    suspend fun createPerson(
        name: String?,
        email: String?,
        password: String?
    ) {

            if (name.isNullOrBlank()) {
                error.value = "O campo nome é obrigatório!"

            } else if (email.isNullOrBlank()) {
                error.value = "O campo email é obrigatório!"

            } else if (password.isNullOrBlank()) {
                error.value = "O campo senha é obrigatório!"

            } else {

                val profileModel = ProfileModel(
                    name = name,
                    email = email,
                    password = password
                )

                viewModelScope.launch {

                val apiResponse = useCase.createProfile(profileModel)
                sucess.value = true

                val saveDb = useCase.getProfileFromLocalDb()

            }

        }
    }
}
