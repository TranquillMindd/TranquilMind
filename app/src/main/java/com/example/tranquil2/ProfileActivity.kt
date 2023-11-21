package com.example.tranquil2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tranquil2.databinding.ActivityProfileBinding
//import com.example.tranquilmind.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example: Set profile information
        binding.usernameLabel.text = "John Doe"
        binding.emailLabel.text = "john.doe@example.com"
    }
}
