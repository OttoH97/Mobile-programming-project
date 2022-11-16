package com.example.mobiiliohjelmointiprojekti.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData:LiveData<List<Kayttaja>>
    private val repository: KayttajaRepository
    init{
        val kayttajaDao = ElokuvaDatabase.getDatabase(application).kayttajaDao()
        repository = KayttajaRepository(kayttajaDao)
        readAllData = repository.readAllData
    }

    fun addKayttaja(kayttaja: Kayttaja){
        viewModelScope.launch(Dispatchers.IO){
            repository.addKayttaja(kayttaja)
        }
    }
}