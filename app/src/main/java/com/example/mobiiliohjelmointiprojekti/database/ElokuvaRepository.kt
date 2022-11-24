package com.example.mobiiliohjelmointiprojekti.database

class ElokuvaRepository(private val dao: ElokuvaDao) {
    val elokuvat = dao.getALlMovies()

    suspend fun insert(elokuva: Elokuva){
        return dao.insert(elokuva)
    }

}