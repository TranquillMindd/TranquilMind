package com.example.tranquilmind

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class LoginAddUser : AppCompatActivity() {

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText
    private lateinit var createUserButton: MaterialButton
    private lateinit var loginTextView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_add_user)

        // Initialize views
        firstNameEditText = findViewById(R.id.ptxt_firstname)
        lastNameEditText = findViewById(R.id.ptxt_lastname)
        emailEditText = findViewById(R.id.ptxt_email)
        passwordEditText = findViewById(R.id.ptxtpassword)
        confirmPasswordEditText = findViewById(R.id.ptxt_cpassword)
        createUserButton = findViewById(R.id.btn_createuser)
        loginTextView = findViewById(R.id.idTVLogin)
        progressBar = findViewById(R.id.progressbar)

        // Set up the Create User button click listener
        createUserButton.setOnClickListener {
            // Validate input fields (you may want to add more thorough validation)
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()) {
                // Show an error message or handle validation as needed
                return@setOnClickListener
            }

            // You can perform user registration logic here
            // For simplicity, we'll just show a progress bar for a few seconds
            showProgressBar()

            // Simulate registration process
            simulateRegistrationProcess()
        }

        // Set up the Login text view click listener (optional)
        loginTextView.setOnClickListener {
            // Implement login redirection logic if needed
        }
    }

    private fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
        // You can customize the progress bar appearance or use an animation if needed
    }

    private fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    private fun simulateRegistrationProcess() {
        // Simulate a registration process (e.g., making a network request)
        // After a successful registration, you can navigate to the next screen or perform other actions
        // For now, we'll just hide the progress bar after a delay
        createUserButton.postDelayed({
            hideProgressBar()
        }, 3000) // 3 seconds delay (adjust as needed)
    }
}
