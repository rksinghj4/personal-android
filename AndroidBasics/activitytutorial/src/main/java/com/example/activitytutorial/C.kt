package com.example.activitytutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    }
}