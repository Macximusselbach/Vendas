package br.com.dionataferraz.vendas.activities.profile.data.remote

import android.util.Log
import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result
import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.activities.profile.data.local.ProfileLocalDataSource
import br.com.dionataferraz.vendas.activities.profile.data.response.ProfileResponse
import br.com.dionataferraz.vendas.database.local.entities.ProfileEntity
import br.com.dionataferraz.vendas.database.remote.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class ProfileRemoteDataSource {

    private val service = RetrofitNetworkClient.createNetworkClient().create(CreateProfileAPI::class.java)

    suspend fun createProfile(profile: ProfileModel): Result<ProfileModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val profileResponse = service.createProfile(profile)
                val profileModel = convertResponseToModel(profileResponse)

                Result.Success(profileModel)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }


    }

    private fun convertResponseToModel(profileToConvert: ProfileResponse): ProfileModel {
        return ProfileModel(
            profileToConvert.name,
            profileToConvert.email,
            profileToConvert.password
        )

    }


}
