package br.com.dionataferraz.vendas.activities.profile.data.repository

import android.util.Log
import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result
import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.activities.profile.data.local.ProfileLocalDataSource
import br.com.dionataferraz.vendas.activities.profile.data.remote.ProfileRemoteDataSource


class ProfileRepository {

    private val localDataSource by lazy {
        ProfileLocalDataSource()
    }

    private val remoteDataSource by lazy {
        ProfileRemoteDataSource()

    }

    suspend fun createProfile(profile: ProfileModel): Result<ProfileModel, ErrorModel> {
        return remoteDataSource.createProfile(profile)

    }

    suspend fun getProfileFromLocalDb(): Result<ProfileModel, ErrorModel> {
        return localDataSource.getProfileFromLocalDb()

    }
}