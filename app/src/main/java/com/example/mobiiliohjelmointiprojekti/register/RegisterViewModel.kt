package com.example.mobiiliohjelmointiprojekti.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mobiiliohjelmointiprojekti.database.ElokuvaDatabase
import com.example.mobiiliohjelmointiprojekti.database.Kayttaja
import com.example.mobiiliohjelmointiprojekti.database.KayttajaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    override fun onCleared() {
        super.onCleared()
    }

    val kayttaja : LiveData<List<Kayttaja>>
    private val repository : KayttajaRepository

    init {
        val kayttajaDao = ElokuvaDatabase.getDatabase(application).kayttajaDao()
        repository = KayttajaRepository(kayttajaDao)
        kayttaja = repository.kayttajat
    }

    fun addKayttaja(kayttaja: Kayttaja) {
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(kayttaja)
        }
    }

}