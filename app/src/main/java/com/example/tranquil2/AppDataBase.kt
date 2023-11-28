package com.example.tranquil2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [JournalMetricEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun JournalMetricDao(): JournalMetricDao

    companion object {
        private const val DATABASE_NAME = "journal_metrics"

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build()
        }
    }
}