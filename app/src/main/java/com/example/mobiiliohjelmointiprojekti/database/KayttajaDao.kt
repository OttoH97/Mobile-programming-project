package com.example.mobiiliohjelmointiprojekti.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface KayttajaDao {
    @Query("SELECT * FROM kayttaja")
    fun readAllData(): LiveData<List<Kayttaja>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun addUser(kayttaja: Kayttaja)
}