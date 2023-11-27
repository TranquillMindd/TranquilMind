package com.example.tranquil2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JournalAdapter(private val journalMetric: List<JournalRecord>) : RecyclerView.Adapter<JournalAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_journal_item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val journalMetric = journalMetric[position]
        holder.journalNameTextView.text = journalMetric.name
        holder.journalEntryTextView.text = journalMetric.journalEntry
        holder.journalDateTextView.text = journalMetric.date
    }

    override fun getItemCount(): Int {
        return journalMetric.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val journalNameTextView: TextView = itemView.findViewById(R.id.journalNameTextView)
        val journalEntryTextView: TextView = itemView.findViewById(R.id.journalEntryTextView)
        val journalDateTextView: TextView = itemView.findViewById(R.id.journalDateTextView)
    }
}