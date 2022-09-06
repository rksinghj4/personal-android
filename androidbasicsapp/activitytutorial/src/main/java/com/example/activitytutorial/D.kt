package com.example.activitytutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytutorial.databinding.ActivityDBinding

class D : AppCompatActivity() {
    lateinit var activityDBinding: ActivityDBinding
    companion object {
        const val ACTIVITY_TEST = "Raj: D"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDBinding = ActivityDBinding.inflate(layoutInflater)
        Log.d(ACTIVITY_TEST, "onCreate is called")

        setContentView(activityDBinding.root)
        activityDBinding.button4.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val bundle =  Bundle()
            bundle.putString("abc", "ABC")
            intent.putExtra("bundle", bundle)
            //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(ACTIVITY_TEST, "onStart is called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(ACTIVITY_TEST, "onRestoreInstanceState is called")
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