package com.example.qrapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       scan.setOnClickListener {
           val intent = Intent(this,scanactivity::class.java)
           startActivity(intent)
       }
        Generator.setOnClickListener {
            val intent=Intent(this,qrgeneratoractivity::class.java)
            startActivity(intent)
        }



    }
}
