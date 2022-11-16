package com.example.mobiiliohjelmointiprojekti.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArvosteluDao {

    @Query("SELECT * FROM arvostelu")
    fun getAll(): List<Arvostelu>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addArvostelu(arvostelu: Arvostelu)

    @Delete
    fun delete(arvostelu: Arvostelu)
}