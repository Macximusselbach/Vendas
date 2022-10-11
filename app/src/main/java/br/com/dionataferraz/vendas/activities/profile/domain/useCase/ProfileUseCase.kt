package br.com.dionataferraz.vendas.activities.profile.domain.useCase

import android.util.Log
import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result
import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.activities.profile.data.repository.ProfileRepository

class ProfileUseCase {

    private val repository by lazy {
        ProfileRepository()
    }

    suspend fun createProfile(profile: ProfileModel): Result<ProfileModel, ErrorModel> {
        return repository.createProfile(profile)

    }

    suspend fun getProfileFromLocalDb(): Result<ProfileModel, ErrorModel> {
        return repository.getProfileFromLocalDb()

    }
}