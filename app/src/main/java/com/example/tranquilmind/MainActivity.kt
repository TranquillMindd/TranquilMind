package com.example.tranquilmind

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addUserButton: MaterialButton = findViewById(R.id.btnAddUser)
        val meditationButton: MaterialButton = findViewById(R.id.btnMeditation)

        addUserButton.setOnClickListener {
            // Create an Intent to launch the LoginAddUser activity
            val intent = Intent(this, LoginAddUser::class.java)

            // Start the LoginAddUser activity
            startActivity(intent)
        }

        meditationButton.setOnClickListener {
            // Create an Intent to launch the MeditationActivity
            val intent = Intent(this, MeditationActivity::class.java)

            // Start the MeditationActivity
            startActivity(intent)
        }
    }

    // You can add this function to handle button click in XML (android:onClick attribute)
    fun onAddUserButtonClick(view: View) {
        val intent = Intent(this, LoginAddUser::class.java)
        startActivity(intent)
    }

    fun onMeditationButtonClick(view: View) {
        val intent = Intent(this, MeditationActivity::class.java)
        startActivity(intent)
    }

}
