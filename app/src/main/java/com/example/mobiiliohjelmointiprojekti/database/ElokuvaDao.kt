package com.example.mobiiliohjelmointiprojekti.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ElokuvaDao {

    @Insert
    suspend fun insert(elokuva: Elokuva)

    @Query("SELECT * FROM Elokuva ORDER BY elokuvaid DESC")
    fun getALlMovies(): LiveData<List<Elokuva>>
}
