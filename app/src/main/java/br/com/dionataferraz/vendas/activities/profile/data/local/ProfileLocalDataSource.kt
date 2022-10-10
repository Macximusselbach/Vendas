package br.com.dionataferraz.vendas.activities.profile.data.local

import android.util.Log
import br.com.dionataferraz.vendas.database.ErrorModel
import br.com.dionataferraz.vendas.database.Result
import br.com.dionataferraz.vendas.activities.profile.ProfileModel
import br.com.dionataferraz.vendas.activities.transactions.TransactionModel
import br.com.dionataferraz.vendas.activities.transactions.TransactionPlace
import br.com.dionataferraz.vendas.activities.transactions.data.response.TransactionResponse
import br.com.dionataferraz.vendas.database.local.VendasDatabase
import br.com.dionataferraz.vendas.database.local.entities.ProfileEntity
import br.com.dionataferraz.vendas.login.data.response.LoginUserResponse
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
                Log.e("createProfile", profile.toString())
                dataBase.profileDao().insert(profile)

                val teste = dataBase.profileDao().getProfile()

                Log.e("profileDao", teste.toString())
                val profileModel = convertEntityToModel(profile)

                Result.Success(profileModel)

            } catch (exception: Exception) {
                Result.Error(ErrorModel)

            }

        }
    }

    suspend fun getProfileFromLocalDb(): Result<ProfileModel, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                val profileEntity = dataBase.profileDao().getProfile()

                val profileModel = convertEntityToModel(profileEntity)

                Result.Success(profileModel)

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

     fun convertResponseToEntity(profileToConvert: LoginUserResponse): ProfileEntity {
        return ProfileEntity(
            profileToConvert.id,
            profileToConvert.name,
            profileToConvert.email,
            profileToConvert.password,
        )

    }


}
