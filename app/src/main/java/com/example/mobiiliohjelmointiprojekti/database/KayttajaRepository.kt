package com.example.mobiiliohjelmointiprojekti.database;

import androidx.lifecycle.LiveData
import java.util.List;

class KayttajaRepository(private val kayttajaDao: KayttajaDao) {
    val readAllData: LiveData<kotlin.collections.List<Kayttaja>> = kayttajaDao.readAllData()
    suspend fun addKayttaja(kayttaja: Kayttaja){
        kayttajaDao.addUser(kayttaja)
    }
}

