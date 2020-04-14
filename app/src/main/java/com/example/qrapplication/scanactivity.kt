package com.example.qrapplication

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.activity_scanactivity.*

class scanactivity : AppCompatActivity() {
    private lateinit var codescanner : CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanactivity)

        codescanner = CodeScanner(this,scanner)

        codescanner.setDecodeCallback(DecodeCallback()
        {
                runOnUiThread(Runnable {
                    run {
                        Result_is.text = Result.toString()
                    }
                })

        })
        requestpermission()
    }

    private fun requestpermission()
    {
        Dexter.withActivity(this).withPermission(Manifest.permission.CAMERA).withListener( object :
            PermissionListener
        {
            override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    codescanner.startPreview()

            }

            override fun onPermissionRationaleShouldBeShown(
                permission: PermissionRequest?,
                token: PermissionToken?
            ) {
                token?.continuePermissionRequest()
            }

            override fun onPermissionDenied(response: PermissionDeniedResponse?) {
            Toast.makeText(this@scanactivity,"camera permission not given ",Toast.LENGTH_SHORT).show()
            }

        }).check()
    }




}
