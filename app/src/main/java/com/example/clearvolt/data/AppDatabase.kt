package com.example.clearvolt.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clearvolt.data.dao.PlacaSolarDao
import com.example.clearvolt.data.entities.PlacaSolarEntity

@Database(entities = [PlacaSolarEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun placaSolarDao(): PlacaSolarDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "clearvolt_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
