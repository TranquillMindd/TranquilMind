package com.example.tranquil2



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface JournalMetricDao {
    @Insert
    fun insert(metric: JournalMetricEntity)

    @Query("SELECT * FROM journal_metrics")
    fun getAllMetrics(): Flow<List<JournalMetricEntity>>
}