package com.example.datamanagement.examfile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.activity_scoped_exam_test.*
import kotlinx.android.synthetic.main.internal_file_mgr.*
import kotlinx.android.synthetic.main.scoped_storage_test.*
import java.io.*

class scopedExamTest : AppCompatActivity() {
    lateinit var file_path :String //늦은 초기화
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoped_exam_test)

        btn_open.setOnClickListener {
            val fileIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            fileIntent.type = "*/*"
            startActivityForResult(fileIntent,100)
        }

        btn_save.setOnClickListener {
            val fileIntent = Intent(Intent.ACTION_CREATE_DOCUMENT)
            //필터링의 조건 =============================
            fileIntent.addCategory(Intent.CATEGORY_OPENABLE)
            fileIntent.type = "*/*"
            startActivityForResult(fileIntent,200)
        }
        btn_new.setOnClickListener {
            detail_edit.setText("")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, myintent: Intent?) {
        super.onActivityResult(requestCode, resultCode, myintent)
        if(requestCode == 100){
            if (resultCode == Activity.RESULT_OK){
                val desc1 = contentResolver.openFileDescriptor(myintent?.data!!,"r")
                val fis = FileInputStream(desc1?.fileDescriptor)
                fis.bufferedReader().forEachLine {
                    detail_edit.append("$it \n")
                }
                fis.close()
            }
        }else if(requestCode == 200){
            if(resultCode == Activity.RESULT_OK){
                val desc2 = contentResolver.openFileDescriptor(myintent?.data!!,"w")
                val fos = FileOutputStream(desc2?.fileDescriptor)
                val data = detail_edit.text.toString()
                val pw = PrintWriter(fos)
                pw.println(data)
                pw.flush()
                pw.close()
            }
        }
    }
}