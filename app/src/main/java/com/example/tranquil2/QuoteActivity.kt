// QuoteActivity.kt
package com.example.tranquil2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuoteActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var quoteAdapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        // Create a list of quotes
        val quotes = listOf(
            Quote("Believe you can and you're halfway there. \n \n - Theodore Roosevelt"),
            Quote("The best way to predict the future is to create it. \n \n - Peter Drucker"),
            Quote("It's not whether you get knocked down, it's whether you get up. \n \n - Vince Lombardi"),
            Quote("The only way to do great work is to love what you do. \n \n - Steve Jobs"),
            Quote("Don't watch the clock; do what it does. Keep going. \n \n - Sam Levenson"),
            Quote("Strive not to be a success, but rather to be of value. \n \n - Albert Einstein"),
            Quote("The only place where success comes before work is in the dictionary. \n \n - Vidal Sassoon"),
            Quote("Your time is limited, don't waste it living someone else's life. \n \n - Steve Jobs"),
            Quote("The future belongs to those who believe in the beauty of their dreams. \n \n - Eleanor Roosevelt"),
            Quote("Success is not final, failure is not fatal: It is the courage to continue that counts. \n \n - Winston Churchill"),
            Quote("I find that the harder I work, the more luck I seem to have. \n \n - Thomas Jefferson"),
            Quote("Don't be pushed around by the fears in your mind. Be led by the dreams in your heart. \n \n - Roy T. Bennett"),
            Quote("The only thing standing between you and your goal is the story you keep telling yourself as to why you can't achieve it. \n \n - Jordan Belfort"),
            Quote("Don't let yesterday take up too much of today. \n \n - Will Rogers"),
            Quote("Learn as if you will live forever, live like you will die tomorrow. \n \n - Mahatma Gandhi"),
            Quote("The only person you are destined to become is the person you decide to be. \n \n - Ralph Waldo Emerson"),
            Quote("In order to succeed, we must first believe that we can. \n \n - Nikos Kazantzakis"),
            Quote("The best revenge is massive success. \n \n - Frank Sinatra"),
            Quote("Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work. And the only way to do great work is to love what you do. \n \n - Steve Jobs"),
            Quote("Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle. \n \n - Christian D. Larson"),
            Quote("You don't have to be great to start, but you have to start to be great. \n \n - Zig Ziglar"),
            Quote("Success is stumbling from failure to failure with no loss of enthusiasm. \n \n - Winston S. Churchill"),
            Quote("What lies behind us and what lies before us are tiny matters compared to what lies within us. \n \n - Ralph Waldo Emerson"),
            Quote("Don't count the days, make the days count. \n \n - Muhammad Ali"),
            Quote("The only way to achieve the impossible is to believe it is possible. \n \n - Charles Kingsleigh"),
            Quote("Success is not just about making money. It's about making a difference. \n \n - Unknown"),
            Quote("Your attitude, not your aptitude, will determine your altitude. \n \n - Zig Ziglar"),
            Quote("The only thing standing between you and your goal is the story you keep telling yourself as to why you can't achieve it. \n \n - Jordan Belfort"),
            Quote("Act as if what you do makes a difference. It does. \n \n - William James"),
            Quote("Success usually comes to those who are too busy to be looking for it. \n \n - Henry David Thoreau"),
            Quote("The only person you are destined to become is the person you decide to be. \n \n - Ralph Waldo Emerson"),
            Quote("The best way to predict the future is to create it. \n \n - Peter Drucker"),
            Quote("Don't watch the clock; do what it does. Keep going. \n \n - Sam Levenson"),
            Quote("Believe you can and you're halfway there. \n \n - Theodore Roosevelt"),
            Quote("It's not whether you get knocked down, it's whether you get up. \n \n - Vince Lombardi"),
            Quote("The only way to do great work is to love what you do. \n \n - Steve Jobs"),
            Quote("Strive not to be a success, but rather to be of value. \n \n - Albert Einstein"),
            Quote("The only place where success comes before work is in the dictionary. \n \n - Vidal Sassoon"),
            Quote("Your time is limited, don't waste it living someone else's life. \n \n - Steve Jobs"),
            Quote("The future belongs to those who believe in the beauty of their dreams. \n \n - Eleanor Roosevelt"),
            Quote("Success is not final, failure is not fatal: It is the courage to continue that counts. \n \n - Winston Churchill"),
            Quote("I find that the harder I work, the more luck I seem to have. \n \n - Thomas Jefferson"),
            Quote("Don't be pushed around by the fears in your mind. Be led by the dreams in your heart. \n \n - Roy T. Bennett"),
            Quote("The only thing standing between you and your goal is the story you keep telling yourself as to why you can't achieve it. \n \n - Jordan Belfort"),
            Quote("Don't let yesterday take up too much of today. \n \n - Will Rogers"),
            Quote("Learn as if you will live forever, live like you will die tomorrow. \n \n - Mahatma Gandhi")
        )

        // Shuffle the list to get random quotes
        val shuffledQuotes = quotes.shuffled()

        // Set up the RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Create and set the adapter with shuffled quotes
        quoteAdapter = QuoteAdapter(shuffledQuotes)
        recyclerView.adapter = quoteAdapter

        // Find the save button by its ID
        val button = findViewById<Button>(R.id.quoteCloseButton)

        // Set a click listener for the save button
        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            true
        }
    }
}
