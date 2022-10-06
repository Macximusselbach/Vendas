package br.com.dionataferraz.vendas.activities.profile.data.repository

import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.activities.profile.data.local.ProfileLocalDataSource
import br.com.dionataferraz.vendas.activities.profile.data.remote.CreateProfileRemoteDataSource
import br.com.dionataferraz.vendas.activities.profile.data.remote.ErrorModel
import br.com.dionataferraz.vendas.activities.profile.data.remote.Result
import br.com.dionataferraz.vendas.activities.profile.data.response.ProfileResponse


class ProfileRepository {

    private val localDataSource by lazy {
        ProfileLocalDataSource()
    }

    private val remoteDataSource by lazy {
        CreateProfileRemoteDataSource()

    }

    suspend fun createProfile(profile: ProfileModel): Result<ProfileResponse, ErrorModel> {
        return remoteDataSource.createProfile(profile)

    }

    suspend fun getProfileFromLocalDb(): Result<ProfileModel, ErrorModel> {
        return localDataSource.getProfileFromLocalDb()

    }
}