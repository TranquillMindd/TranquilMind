package com.example.tranquil2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "journal_metrics")
data class JournalMetricEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name="name") val name: String,
    @ColumnInfo(name="date") val date: String,
    @ColumnInfo(name="journalEntry") val journalEntry: String
)