package com.example.activitytutorial

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.activitytutorial.databinding.ActivityMainTutorialBinding

class MainActivityTutorial : AppCompatActivity() {
    companion object {
        val ACTIVITY_TEST = "MainActivity: Raj"
    }

    lateinit var activityMainBinding: ActivityMainTutorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainTutorialBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        Log.d(ACTIVITY_TEST, "onCreate is called")

        activityMainBinding.button.setOnClickListener {
            //showDialog()
            //showDialogFragment()
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

    fun showDialog(){
        Log.d(ACTIVITY_TEST, "showDialog is called")
        val alertDialog = AlertDialog.Builder(this).setTitle("Alert Dialog")
            .setPositiveButton("OK")  {_, _ ->

            }
            .setNegativeButton("No") {_,_ ->

            }.create().show()
    }

    fun showDialogFragment() {
            DialogFragment().show(supportFragmentManager, "MainActivityTutorial")
    }

}









