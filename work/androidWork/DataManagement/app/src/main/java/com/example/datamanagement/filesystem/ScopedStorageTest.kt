package com.example.datamanagement.filesystem

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.scoped_storage_test.*
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.FileInputStream
import java.io.FileOutputStream

class ScopedStorageTest : AppCompatActivity() {
    //내부저장소의 앱데이터 디렉토리 경로
    lateinit var file_path: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scoped_storage_test)
        //type
        //null이면 업데이터 폴더의 경로를 얻어온다.
        //Environment.DIRECTORY_종류별 폴더명
        file_path = getExternalFilesDir(null).toString()
        Log.d("myfile", file_path)

        appdata_save.setOnClickListener {
            val fos = FileOutputStream("$file_path/myAppFile.txt")
            val dos = DataOutputStream(fos)

            dos.writeUTF("App데이터 디렉토리에 저장")
            dos.writeInt(100000)
            dos.flush()
            dos.close()

            scoped_text.text = "앱데이터 경로에 저장완료"
        }
        appdata_open.setOnClickListener {
            val fis = FileInputStream("$file_path/myAppFile.txt")
            val dis = DataInputStream(fis)
            val inputdata = "앱데이터 경로에서 읽은 데이터:${dis.readUTF()},${dis.readInt()}"
            scoped_text.text = inputdata
        }

        download_save.setOnClickListener {
            //파일관리앱(쓰기용)을 실행 -intent
            val fileIntent = Intent(Intent.ACTION_CREATE_DOCUMENT)
            //필터링의 조건 ================================
            fileIntent.addCategory(Intent.CATEGORY_OPENABLE) //읽을 수 있는 파일
            fileIntent.type = "*/*" //전체파일
            startActivityForResult(fileIntent, 100)
        }

        download_open.setOnClickListener {
            val fileIntent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            fileIntent.type = "*/*"
            startActivityForResult(fileIntent, 200)
        }
        }


    override fun onActivityResult(requestCode: Int, resultCode: Int, myintent: Intent?) {
        super.onActivityResult(requestCode, resultCode, myintent)
        if (requestCode == 100) {
            if (resultCode == Activity.RESULT_OK) {
                //download폴더에 파일저장
                //해당파일에 접근할 수 있도록 경로, 파일에 대한 정보를 myintent필터에 가지고 되돌아온다.
                //contentResolver는 다른 프로그램에서 제공하는 데이터를 가지고 올때 사용
                val desc1 = contentResolver.openFileDescriptor(myintent?.data!!,"w")
                val fos = FileOutputStream(desc1?.fileDescriptor)
                val dos = DataOutputStream(fos)
                dos.writeUTF("download 디렉토리에 저장")
                dos.writeInt(20000)
                dos.flush()
                dos.close()
                scoped_text.text = "download폴더에 저장완료"
            }
        }else if(requestCode==200) {
            if (resultCode == Activity.RESULT_OK) {
                //download폴더에 저장된 파일읽기
                val desc2 = contentResolver.openFileDescriptor(myintent?.data!!, "r")
                //          ---------------
                //          파일접근하게 해주는 객체

                val fis = FileInputStream(desc2?.fileDescriptor)
                val dis = DataInputStream(fis)
                val inputdata = "download에서 읽은 데이터:${dis.readUTF()},${dis.readInt()}"
                scoped_text.text = inputdata
                dis.close()
            }
        }
    }
}