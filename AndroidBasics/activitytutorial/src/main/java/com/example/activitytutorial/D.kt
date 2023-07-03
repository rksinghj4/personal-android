package com.example.activitytutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activitytutorial.databinding.ActivityDBinding

class D : AppCompatActivity() {
    private lateinit var activityD: ActivityDBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_d)
        activityD = ActivityDBinding.inflate(layoutInflater)
        setContentView(activityD.root)
        activityD.button4.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val bundle =  Bundle()
            bundle.putString("abc", "ABC")
            intent.putExtra("bundle", bundle)
            //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}