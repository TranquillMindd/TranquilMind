package com.example.tranquil2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
class JournalEntriesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val journalList: MutableList<JournalRecord> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal_view)

        recyclerView = findViewById(R.id.recyclerView)
        val adapter = JournalAdapter(journalList)

        lifecycleScope.launch {
            (application as JournalApplication).database.JournalMetricDao().getAllMetrics()
                .collect { databaseList ->
                    databaseList.map { entity ->
                        JournalRecord(
                            entity.name,
                            entity.date,
                            entity.journalEntry
                        )
                    }.also { mappedList ->
                        journalList.clear()
                        journalList.addAll(mappedList)
                        adapter.notifyDataSetChanged()
                    }
                }
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val addSessionBtn = findViewById<Button>(R.id.addButton)

        addSessionBtn.setOnClickListener {
            // launch the detail activity
            val intent = Intent(this, AddJournalActivity::class.java)
            this.startActivity(intent)
        }
    }
}