package br.com.dionataferraz.vendas.activities.profile.domain.useCase

import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.activities.profile.data.remote.ErrorModel
import br.com.dionataferraz.vendas.activities.profile.data.remote.Result
import br.com.dionataferraz.vendas.activities.profile.data.repository.ProfileRepository
import br.com.dionataferraz.vendas.activities.profile.data.response.ProfileResponse

class ProfileUseCase {

    private val repository by lazy {
        ProfileRepository()
    }

    suspend fun createProfile(profile: ProfileModel): Result<ProfileResponse, ErrorModel> {
        return repository.createProfile(profile)

    }

    suspend fun getProfileFromLocalDb(): Result<ProfileModel, ErrorModel> {
        return repository.getProfileFromLocalDb()

    }
}