package com.example.tranquil2

import android.app.Application

class JournalApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
}