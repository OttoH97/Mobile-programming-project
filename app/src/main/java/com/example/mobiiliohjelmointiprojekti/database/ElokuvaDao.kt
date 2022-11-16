package com.example.mobiiliohjelmointiprojekti.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface ElokuvaDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun addElokuva(elokuva: Elokuva)

}