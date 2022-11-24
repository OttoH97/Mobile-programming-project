package com.example.mobiiliohjelmointiprojekti.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface RegisterDao {

    @Insert
    suspend fun insert(register: Kayttaja)

    @Query("SELECT * FROM Kayttaja ORDER BY kayttajaid DESC")
    fun getAllUsers(): LiveData<List<Kayttaja>>

    @Query("SELECT * FROM kayttaja WHERE user_name LIKE :tunnus ")
    suspend fun getUserName(tunnus: String): Kayttaja?

}