package com.example.mobiiliohjelmointiprojekti.database

class KayttajaRepository(private val dao: RegisterDao){
    val kayttajat = dao.getAllUsers()

    suspend fun insert(kayttaja: Kayttaja){
        return dao.insert(kayttaja)
    }
    suspend fun getUserName(tunnus:String):Kayttaja?{
        return dao.getUserName(tunnus)
    }
//    suspend fun checkLogin(loggedIn: Boolean):Kayttaja? {
//        return dao.checkLogin(loggedIn)
//    }
}