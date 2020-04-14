package com.example.qrapplication

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.qrcode.QRCodeWriter
import kotlinx.android.synthetic.main.activity_q_ractivity.*

class QRactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q_ractivity)

        val bundle : Bundle? =intent.extras

        val QRText = bundle!!.getString("data")

        val qrencoder = QRGEncoder(QRText,null,QRGContents.Type.TEXT,500)
        try {
            var bitmap : Bitmap =qrencoder.encodeAsBitmap()
            imageView.setImageBitmap(bitmap)
        }
        catch (e : Exception)
        {
            e.printStackTrace()
        }

    }
}
