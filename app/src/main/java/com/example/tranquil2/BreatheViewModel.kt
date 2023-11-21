package com.example.tranquil2

import androidx.lifecycle.ViewModel

class BreatheViewModel : ViewModel() {

    private var breatheMin: Int = 0
    private var breatheCount: Int = 0

    fun updateBreatheMin(minutesCompleted: Int) {
        breatheMin = minutesCompleted
        // Perform any additional logic or update operations as needed
    }

    fun updateBreatheCount() {
        breatheCount++
        // Perform any additional logic or update operations as needed
    }

    // Add getter methods if necessary
    fun getBreatheMin(): Int {
        return breatheMin
    }

    fun getBreatheCount(): Int {
        return breatheCount
    }
}
