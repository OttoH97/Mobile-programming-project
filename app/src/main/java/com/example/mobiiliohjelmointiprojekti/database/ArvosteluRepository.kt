package com.example.mobiiliohjelmointiprojekti.database

class ArvosteluRepository(private val dao: ArvosteluDao) {
    val arvostelut = dao.getAllReviews()

    suspend fun insert(arvostelu: Arvostelu){
        return dao.insert(arvostelu)
    }

}