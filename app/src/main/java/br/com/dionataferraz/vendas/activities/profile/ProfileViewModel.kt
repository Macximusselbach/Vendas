package br.com.dionataferraz.vendas.activities.profile


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
    private val sucess: MutableLiveData<Boolean> = MutableLiveData()
    val sucessSave: LiveData<Boolean> = sucess

    fun createPerson(
        name: String?,
        age: String?,
        email: String?,
        password: String?,
        gender: String?
    ) {
        if (name.isNullOrBlank()
            && age.isNullOrBlank()
            && email.isNullOrBlank()
            && password.isNullOrBlank()
            && gender.isNullOrBlank()
        ) {
            error.value = "Preencha todos os campos!"

        } else if (name.isNullOrBlank()) {
            error.value = "O campo nome é obrigatório!"

        } else if (age.isNullOrBlank()) {
            error.value = "O campo idade é obrigatório!"

        } else if (email.isNullOrBlank()) {
            error.value = "O campo email é obrigatório!"

        } else if (password.isNullOrBlank()) {
            error.value = "O campo senha é obrigatório!"

        } else if (gender.isNullOrBlank()) {
            error.value = "O campo gênero é obrigatório!"

        } else {

            val profileModelCreated = ProfileModel(
                name = name,
                email = email,
                password = password
            )

            viewModelScope.launch {
                useCase.createProfile(profileModelCreated)
                sucess.value = true

            }

        }
    }

}