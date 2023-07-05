package com.example.activitytutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytutorial.databinding.ActivityCBinding

class C : AppCompatActivity() {
    private lateinit var activityC: ActivityCBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_c)
        activityC = ActivityCBinding.inflate(layoutInflater)
        setContentView(activityC.root)
        activityC.button3.setOnClickListener {
            val intent = Intent(this, D::class.java)
            //intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
        Log.d(ACTIVITY_TEST, "C Activity onCreate is called")

    }


    override fun onStart() {
        super.onStart()
        Log.d(ACTIVITY_TEST, "C onStart is called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(ACTIVITY_TEST, "C Activity onRestoreInstanceState is called")
    }


    override fun onRestart() {
        super.onRestart()
        Log.d(ACTIVITY_TEST, "C onRestart is called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ACTIVITY_TEST, "C onResume is called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ACTIVITY_TEST, "C onPause is called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(ACTIVITY_TEST, "onSaveInstanceState is called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ACTIVITY_TEST, "C onStop is called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ACTIVITY_TEST, "C onDestroy is called")
    }

    companion object {
        const val ACTIVITY_TEST = "RajC"
    }
}