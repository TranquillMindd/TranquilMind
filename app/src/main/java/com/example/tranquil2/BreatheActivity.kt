package com.example.tranquil2

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.airbnb.lottie.LottieAnimationView
import com.example.tranquil2.databinding.ActivityBreatheBinding
import java.util.*
import java.util.concurrent.TimeUnit

class BreatheActivity : AppCompatActivity() {
    private lateinit var textIndicator: TextView
    private lateinit var timer: CountDownTimer
    private var isRunning = false
    private var minutes = 3L
    private lateinit var tts: TextToSpeech
    private lateinit var binding: ActivityBreatheBinding
    private lateinit var lottieAnimationView: LottieAnimationView
    private lateinit var viewModel: BreatheViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreatheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lottieAnimationView = findViewById(R.id.animationView)
        lottieAnimationView.setAnimation(R.raw.animation)
        lottieAnimationView.loop(true)

        viewModel = ViewModelProvider(this).get(BreatheViewModel::class.java)

        textIndicator = binding.indicator
        timer = createTimer()

        binding.start.setOnClickListener {
            toggle()
        }

        binding.close.setOnClickListener {
            showDialog()
        }
    }

    private fun toggle() {
        if (isRunning) {
            stopExercise()
            binding.start.text = getString(R.string.start)
        } else {
            textIndicator.text = "" // Clear the text
            timer.start()
            lottieAnimationView.progress = 0f // Reset animation progress
            lottieAnimationView.playAnimation() // Start Lottie animation

            initializeTextToSpeech()
        }
    }

    private fun initializeTextToSpeech() {
        tts = TextToSpeech(applicationContext) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts.language = Locale.US
                tts.setSpeechRate(0.8F)
            }
        }
    }

    private fun createTimer(): CountDownTimer {
        return object : CountDownTimer(3 * 60000, 1000) {
            var sec = 0L

            override fun onTick(ms: Long) {
                isRunning = true
                minutes =
                    TimeUnit.MILLISECONDS.toMinutes(ms) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ms))
                sec =
                    TimeUnit.MILLISECONDS.toSeconds(ms) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ms))

                textIndicator.text =
                    "${minutes.toString().padStart(2, '0')}:${sec.toString().padStart(2, '0')}"

                if (minutes == 2L && sec == 57L) {
                    tts.speak(
                        "Inhale through your nose and exhale through your mouth",
                        TextToSpeech.QUEUE_ADD,
                        null
                    )
                }
            }

            override fun onFinish() {
                stopExercise()
                lottieAnimationView.pauseAnimation() // Pause Lottie animation
            }
        }
    }

    private fun stopExercise() {
        isRunning = false
        timer.cancel()
        binding.indicator.text = getString(R.string.exercise_completed)
    }

    private fun showDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setMessage(getString(R.string.stop_exercise_confirmation))
            .setCancelable(true)
            .setPositiveButton(getString(R.string.yes)) { dialog, which ->
                finish()
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, which -> dialog.cancel() }

        val alert = builder.create()
        alert.setTitle(getString(R.string.are_you_sure))
        alert.show()
    }

    override fun onStop() {
        super.onStop()

        // Release the TextToSpeech instance
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }

        // Check if viewModel is initialized before updating
        if (::viewModel.isInitialized) {
            viewModel.updateBreatheMin((3L - minutes).toInt())
            viewModel.updateBreatheCount()
        }

        timer.cancel()
    }
}
