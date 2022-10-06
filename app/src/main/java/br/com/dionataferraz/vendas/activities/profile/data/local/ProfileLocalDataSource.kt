package br.com.dionataferraz.vendas.activities.profile.data.local

import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.activities.profile.data.remote.ErrorModel
import br.com.dionataferraz.vendas.activities.profile.data.remote.Result
import br.com.dionataferraz.vendas.database.local.VendasDatabase
import br.com.dionataferraz.vendas.database.local.entities.ProfileEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class ProfileLocalDataSource {

    private val dataBase by lazy {
        VendasDatabase.getInstance()
    }

    suspend fun getProfileFromLocalDb(): Result<ProfileModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val profileEntity = dataBase.profileDao().getProfile()
                val profileModel = convertEntityToModel(profileEntity)

                Result.Sucesss(profileModel)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }

    }

    private fun convertEntityToModel(profileToConvert: ProfileEntity): ProfileModel {
        return ProfileModel(
            profileToConvert.name,
            profileToConvert.email,
            profileToConvert.password
        )

    }
}