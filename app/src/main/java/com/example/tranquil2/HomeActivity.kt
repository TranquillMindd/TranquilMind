package com.example.tranquil2
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Example: Implement a NavigationView for the menu
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        val menu = navigationView.menu
        for (i in 0 until menu.size()) {
            val menuItem = menu.getItem(i)
            val spannable = SpannableString(menuItem.title)
            spannable.setSpan(ForegroundColorSpan(Color.WHITE), 0, spannable.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            menuItem.title = spannable
        }
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_breathing -> {
                    // Handle breathing exercise menu item click
                    // Start a new activity or show a dialog for the breathing exercise
                    val intent = Intent(this, BreatheActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_mindfulness -> {
                    // Handle mindfulness exercise menu item click
                    // Start a new activity or show a dialog for the mindfulness exercise
                    val intent = Intent(this, MeditationActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_quote -> {
                    // Handle quote card menu item click
                    // Start a new activity for the quote card
                    val intent = Intent(this, QuoteActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_profile -> {
                    // Handle profile menu item click
                    // Start the profile activity
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}