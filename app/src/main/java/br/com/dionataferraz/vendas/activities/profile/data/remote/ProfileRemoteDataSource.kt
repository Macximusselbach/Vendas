package br.com.dionataferraz.vendas.activities.profile.data.remote

import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.activities.profile.data.response.ProfileResponse
import br.com.dionataferraz.vendas.database.local.VendasDatabase
import br.com.dionataferraz.vendas.database.local.entities.ProfileEntity
import br.com.dionataferraz.vendas.database.remote.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class CreateProfileRemoteDataSource {

    private val localDataBase by lazy {
        VendasDatabase.getInstance()
    }

    private val service =
        RetrofitNetworkClient.createNetworkClient().create(CreateProfileAPI::class.java)

    suspend fun createProfile(profile: ProfileModel): Result<ProfileResponse, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val profileResponse = service.createProfile(profile)
                val profileEntity = convertResponseToEntity(profileResponse)
                localDataBase.profileDao().insertProfileUser(profileEntity)

                Result.Sucesss(profileResponse)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }


    }


    private fun convertResponseToEntity(profileToConvert: ProfileResponse): ProfileEntity {
        return ProfileEntity(
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

object ErrorModel
sealed class Result<out S, out E> {
    data class Sucesss<S>(val value: S) : Result<S, Nothing>()
    data class Error<E>(val value: E) : Result<Nothing, E>()

    fun get(): S? {
        return when (this) {
            is Sucesss -> value
            else -> null
        }
    }
}