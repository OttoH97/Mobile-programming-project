package com.example.mobiiliohjelmointiprojekti.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface ArvosteluDao {

    @Insert
    suspend fun insert(arvostelu: Arvostelu)

    @Query("SELECT * FROM Arvostelu ORDER BY arvosteluid")
    fun getAllReviews(): LiveData<List<Arvostelu>>

    @Query("SELECT * FROM Arvostelu WHERE arvosteluid = arvosteluid")
    fun getArvosteluFromId(): LiveData<List<Arvostelu>>
}