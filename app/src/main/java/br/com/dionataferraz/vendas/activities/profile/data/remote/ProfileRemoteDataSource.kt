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

class CreateProfileRemoteDataSource {

    private val localDataBase by lazy {
        ProfileLocalDataSource()
    }

    private val service = RetrofitNetworkClient.createNetworkClient().create(CreateProfileAPI::class.java)

    suspend fun createProfile(profile: ProfileModel): Result<ProfileModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val profileResponse = service.createProfile(profile)
                Log.e("Response api ", profileResponse.toString())

                val profileEntity = convertResponseToEntity(profileResponse)
                val profileModel = convertResponseToModel(profileResponse)

                localDataBase.createProfile(profileEntity)

                Result.Sucesss(profileModel)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }


    }


    private fun convertResponseToEntity(profileToConvert: ProfileResponse): ProfileEntity {
        return ProfileEntity(
            profileToConvert.id,
            profileToConvert.name,
            profileToConvert.email,
            profileToConvert.password
        )

    }


    private fun convertResponseToModel(profileToConvert: ProfileResponse): ProfileModel {
        return ProfileModel(
            profileToConvert.name,
            profileToConvert.email,
            profileToConvert.password
        )

    }


}
