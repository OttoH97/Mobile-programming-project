package com.example.mobiiliohjelmointiprojekti.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArvosteluViewModel(application: Application): AndroidViewModel (application) {
    private val readAllData:LiveData<List<Arvostelu>>
    private val repository:ArvosteluRepository
    init{
        val arvosteluDao = ElokuvaDatabase.getDatabase(application).arvosteluDao()
        repository = ArvosteluRepository(arvosteluDao)
        readAllData = repository.readAllData
    }

    fun addArvostelu(arvostelu: Arvostelu){
        viewModelScope.launch(Dispatchers.IO){
            repository.addArvostelu((arvostelu))
        }
    }
}