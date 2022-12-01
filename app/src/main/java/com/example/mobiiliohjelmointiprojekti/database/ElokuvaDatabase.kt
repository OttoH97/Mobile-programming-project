package com.example.mobiiliohjelmointiprojekti.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Arvostelu::class],version = 1, exportSchema = false)
abstract class ElokuvaDatabase : RoomDatabase() {
    abstract fun arvosteluDao() : ArvosteluDao

    companion object {

        @Volatile
        private var INSTANCE: ElokuvaDatabase? = null

        fun getDatabase(context: Context): ElokuvaDatabase{
            synchronized(this){

                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ElokuvaDatabase::class.java,
                        "elokuva_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}