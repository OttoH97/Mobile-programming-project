package com.example.mobiiliohjelmointiprojekti.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Kayttaja::class],version = 1, exportSchema = false)
abstract class ElokuvaDatabase : RoomDatabase() {
    abstract val registerDao: RegisterDao

    companion object {

        @Volatile
        private var INSTANCE: ElokuvaDatabase? = null

        fun getInstance(context: Context): ElokuvaDatabase{
            synchronized(this){

                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ElokuvaDatabase::class.java,
                        "elokuvaDatabase"
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