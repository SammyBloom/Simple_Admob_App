package com.example.moviedisplay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class InputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val button = findViewById<Button>(R.id.button)
        val inputText = findViewById<TextInputEditText>(R.id.movieId)
        val movie_id = inputText.text.toString()
        Log.d("movieID", movie_id)

        button.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
                .apply {
                putExtra("MOVIE_Id", movie_id)
            }
            startActivity(intent)
        }
    }
}