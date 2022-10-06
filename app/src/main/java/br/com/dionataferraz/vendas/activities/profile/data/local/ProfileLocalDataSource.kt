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
                Log.e("Chegou aqui", "fun de insert")
                val salvou = dataBase.profileDao().insertProfileUser(profile)
                Log.e("Realmente salvou ", salvou.toString())

                val profileModel = convertEntityToModel(profile)

                Result.Sucesss(profileModel)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }

        }
    }

    suspend fun getProfileFromLocalDb(): Result<ProfileModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                Log.e("Chegou aqui (plds)", "entrou na fun de get")
                val profileEntity = dataBase.profileDao().getProfile()
                Log.e("Realmente pegou", profileEntity.toString())

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
            profileToConvert.password,
        )

    }
}
