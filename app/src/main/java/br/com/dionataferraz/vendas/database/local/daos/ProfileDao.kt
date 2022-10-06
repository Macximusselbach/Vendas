package br.com.dionataferraz.vendas.database.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.dionataferraz.vendas.database.local.entities.ProfileEntity

@Dao
interface ProfileDao {

    @Insert
    fun insertProfileUser(userEntity: ProfileEntity)

    @Query("SELECT * FROM userTable")
    fun getProfile(): List<ProfileEntity>

}