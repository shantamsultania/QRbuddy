package com.example.qrapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_qrgeneratoractivity.*

class qrgeneratoractivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrgeneratoractivity)

        button_generate.setOnClickListener {

            var data : String =  take_text.text.toString()

            if (data.isEmpty())
            {
                take_text.error = "data Required"
                Toast.makeText(this,"Please enter Valid data", Toast.LENGTH_LONG).show()
                Log.d("Data is ", "this is the data entered by user $data")
            }
            else {
                Log.d("Data is ", "this is the data entered by user  $data")
                val intent = Intent(this, QRactivity::class.java)
                intent.putExtra("data", data)
                Toast.makeText(this, "Thanks you for choosing the QR generator", Toast.LENGTH_LONG).show()
                startActivity(intent)
            }
        }
    }
}
