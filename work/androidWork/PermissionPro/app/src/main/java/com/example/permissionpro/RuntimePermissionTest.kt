package com.example.permissionpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_runtime_permission_test.*

class RuntimePermissionTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runtime_permission_test)
        run_camera.setOnClickListener {
            val myintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(myintent,30)
        }
    }
}