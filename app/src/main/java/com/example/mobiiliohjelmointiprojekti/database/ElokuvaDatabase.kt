package com.example.mobiiliohjelmointiprojekti.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Kayttaja::class,Elokuva::class,Arvostelu::class], version = 1)
abstract class ElokuvaDatabase : RoomDatabase() {
    abstract fun arvosteluDao() : ArvosteluDao
    abstract fun elokuvaDao() : ElokuvaDao
    abstract fun kayttajaDao() : KayttajaDao

    companion object{
        @Volatile
        private var INSTANCE : ElokuvaDatabase? = null

        fun getDatabase(context: Context):ElokuvaDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ElokuvaDatabase::class.java,
                    "ElokuvaDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}



