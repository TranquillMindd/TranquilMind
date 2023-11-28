package com.example.tranquil2

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.airbnb.lottie.LottieAnimationView

class MeditationActivity : AppCompatActivity() {
    private lateinit var timerTextView: TextView
    private lateinit var startButton: MaterialButton
    private lateinit var closeButton: MaterialButton
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var animationView: LottieAnimationView

    private var isTimerRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditation)

        // Initialize views
        timerTextView = findViewById(R.id.indicator)
        startButton = findViewById(R.id.start)
        animationView = findViewById(R.id.animationView)
        closeButton = findViewById(R.id.close)

        // Set up the CountDownTimer (20 minutes in this example)
        val initialTime = 20 * 60 * 1000 // 20 minutes in milliseconds
        countDownTimer = object : CountDownTimer(initialTime.toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                updateTimerText(millisUntilFinished)
            }

            override fun onFinish() {
                // Timer finished, perform any actions needed
                timerTextView.text = "00:00" // You can update this text as per your requirement
                isTimerRunning = false
                startButton.text = "Start"
            }
        }

        // Set up the start button click listener
        startButton.setOnClickListener {
            // Start or stop the timer based on the current state
            if (isTimerRunning) {
                countDownTimer.cancel()
                isTimerRunning = false
                startButton.text = "Start"
            } else {
                countDownTimer.start()
                isTimerRunning = true
                startButton.text = "Pause"
            }
        }

        closeButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            true
        }
    }

    private fun updateTimerText(millisUntilFinished: Long) {
        val minutes = millisUntilFinished / 60000
        val seconds = (millisUntilFinished % 60000) / 1000
        val timeLeft = String.format("%02d:%02d", minutes, seconds)
        timerTextView.text = timeLeft
    }
}
