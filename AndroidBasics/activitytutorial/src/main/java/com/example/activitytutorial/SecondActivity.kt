package com.example.activitytutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytutorial.MainActivity.Companion.ACTIVITY_TEST
import com.example.activitytutorial.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var secondBinding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_second)
        secondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(secondBinding.root)

        Log.d(ACTIVITY_TEST, "SECOND Activity onCreate is called")
        secondBinding.button2.setOnClickListener {
            //showDialog()
            val intent = Intent(this, C::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(ACTIVITY_TEST, "SECOND Activity onStart is called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(ACTIVITY_TEST, "SECOND Activity onRestoreInstanceState is called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(ACTIVITY_TEST, "SECOND Activity onRestart is called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ACTIVITY_TEST, "SECOND Activity onResume is called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ACTIVITY_TEST, "SECOND Activity onPause is called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(ACTIVITY_TEST, "SECOND Activity onSaveInstanceState is called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ACTIVITY_TEST, "SECOND Activity onStop is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ACTIVITY_TEST, "SECOND Activity onDestroy is called")
    }

}