package com.example.tranquil2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class AddJournalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal)

        val journalDao = (application as JournalApplication).database.JournalMetricDao()

        // Find the EditText views by their IDs
        val journalNameEditText = findViewById<EditText>(R.id.JournalNameEditText)
        val journalEntryEditText = findViewById<EditText>(R.id.JournalEntryEditText)
        val journalDateEditText = findViewById<EditText>(R.id.JournalDateEditText)

        // Find the save button by its ID
        val button = findViewById<Button>(R.id.journalButtonSave)

        // Set a click listener for the save button
        button.setOnClickListener {
            val journalName = journalNameEditText.text.toString().trim()// edit
            val journalText = journalEntryEditText.text.toString()
            val journalDate = journalDateEditText.text.toString()

            if (journalName.isNotEmpty() && journalText.isNotEmpty() && journalDate.isNotEmpty()) {
                val journalRecord = JournalMetricEntity(
                    name = journalName,
                    date = journalDate,
                    journalEntry = journalText
                )
                saveJournalRecord(journalDao, journalRecord)
            }

            val intent = Intent(this, JournalEntriesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveJournalRecord(journalDao: JournalMetricDao, journalRecord: JournalMetricEntity) {
        runBlocking {
            launch(Dispatchers.IO) {
                journalDao.insert(journalRecord)
            }
        }
        finish()
    }
}