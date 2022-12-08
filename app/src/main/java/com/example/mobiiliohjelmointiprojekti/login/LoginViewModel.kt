package com.example.mobiiliohjelmointiprojekti.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobiiliohjelmointiprojekti.database.ElokuvaDatabase
import com.example.mobiiliohjelmointiprojekti.database.Kayttaja
import com.example.mobiiliohjelmointiprojekti.database.KayttajaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

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

    fun checkKayttaja(tunnus: String) {
        viewModelScope.launch(Dispatchers.IO){
            repository.getUserName(tunnus)
        }
    }



}