package com.example.mobiiliohjelmointiprojekti.database;

import androidx.lifecycle.LiveData;

import java.util.List;

class ArvosteluRepository(private val arvosteluDao: ArvosteluDao) {
    val readAllData: LiveData<kotlin.collections.List<Arvostelu>> = arvosteluDao.readAllData()
    suspend fun addArvostelu(arvostelu: Arvostelu){
        arvosteluDao.addArvostelu(arvostelu)
    }
}