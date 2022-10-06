package br.com.dionataferraz.vendas.activities.profile.data.local

import android.util.Log
import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result
import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.database.local.VendasDatabase
import br.com.dionataferraz.vendas.database.local.entities.ProfileEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class ProfileLocalDataSource {

    private val dataBase by lazy {
        VendasDatabase.getInstance()
    }


    suspend fun createProfile(profile: ProfileEntity): Result<ProfileModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                dataBase.profileDao().insertProfileUser(profile)
                val profileModel = convertEntityToModel(listOf(profile))

                Result.Sucesss(profileModel)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }

        }
    }

    suspend fun getProfileFromLocalDb(): Result<ProfileModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                Log.e("Chegou aqui (plds)", "@")
                val profileEntity = dataBase.profileDao().getProfile()
                Log.e("Chegou aqui (plds)", profileEntity[0].toString())

                val profileModel = convertEntityToModel(profileEntity)

                Result.Sucesss(profileModel)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }
        }

    }

    private fun convertEntityToModel(profileToConvert: List<ProfileEntity>): ProfileModel {
        return ProfileModel(
            profileToConvert[0].name,
            profileToConvert[0].email,
            profileToConvert[0].password,
        )

    }
}
