package com.example.activitytutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytutorial.databinding.ActivityCBinding

class C : AppCompatActivity() {
    lateinit var activityCBinding: ActivityCBinding

    companion object {
        const val ACTIVITY_TEST = "Raj: C"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCBinding = ActivityCBinding.inflate(layoutInflater)
        setContentView(activityCBinding.root)
        Log.d(ACTIVITY_TEST, "onCreate is called")

        activityCBinding.button3.setOnClickListener {
            val intent = Intent(this, D::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(ACTIVITY_TEST, "onStart is called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(ACTIVITY_TEST, "onRestoreInstanceState is called " + savedInstanceState.getString("name"))
    }


    override fun onRestart() {
        super.onRestart()
        Log.d(ACTIVITY_TEST, "onRestart is called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ACTIVITY_TEST, "onResume is called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ACTIVITY_TEST, "onPause is called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("name", "Raj")
        super.onSaveInstanceState(outState)
        Log.d(ACTIVITY_TEST, "onSaveInstanceState is called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ACTIVITY_TEST, "onStop is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ACTIVITY_TEST, "onDestroy is called")
    }
}