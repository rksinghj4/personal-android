package com.example.activitytutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.activitytutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        Log.d(ACTIVITY_TEST, "onCreate is called")

        mainBinding.button.setOnClickListener {
            //showDialog()
            val intent = Intent(this, SecondActivity::class.java)

            //intent.flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(ACTIVITY_TEST, "onStart is called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(ACTIVITY_TEST, "Activity onRestoreInstanceState is called")
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

    fun showDialog() {
        Log.d(ACTIVITY_TEST, "showDialog is called")
        val alertDialog = AlertDialog.Builder(this).setTitle("Alert Dialog")
            .setPositiveButton("OK") { _, _ ->

            }
            .setNegativeButton("No") { _, _ ->

            }.create().show()
    }

    companion object {
        val ACTIVITY_TEST = "RajM"
    }
}