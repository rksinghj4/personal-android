package com.example.androidbasicsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.activitytutorial.MainActivityTutorial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonToStart).setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivityTutorial::class.java)
            startActivity(intent)
        }
    }
}