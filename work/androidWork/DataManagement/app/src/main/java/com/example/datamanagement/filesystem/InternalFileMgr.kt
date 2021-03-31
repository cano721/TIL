package com.example.datamanagement.filesystem

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.internal_file_mgr.*
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.PrintWriter

class InternalFileMgr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.internal_file_mgr)
        //파일저장하기
        internal_fileSave.setOnClickListener {
            //FileOutputStream객체 리턴
            //openFileOutput
            // - 파일명
            // - mode : MODE_APPEND: 기존 파일에 내용을 추가
            //          MODE_PRIVATE: 기존파일 덮어쓰기

            val fos = openFileOutput("myfile1.txt", Context.MODE_PRIVATE)
            //FOS를 이용해서 기본형으로 바로 입출력할 수 있는 출력스트림클래스 중 DataOutputStream을 생성
            val dos = DataOutputStream(fos)
            //기본형 데이터를 파일에 출력
            dos.writeDouble(3.14)
            dos.writeUTF("테스트중....")
            dos.flush() // 버퍼비우기
            dos.close() // 파일을 닫기
            fileTxt.text = "저장완료"
        }
        //내부저장소에 저장된 파일 읽기
        internal_fileopen.setOnClickListener {
            val fis = openFileInput("myfile1.txt")
            val dis = DataInputStream(fis)
            val inputdata = "내부저장소에서 읽은 데이터:\n${dis.readDouble()},${dis.readUTF()}"
            fileTxt.text = inputdata
        }

        //EditText에 입력한 값을 읽어서 저장하기
        internal_fileSave2.setOnClickListener {
            val fos = openFileOutput("myfile2.txt",Context.MODE_PRIVATE)
            val data = file_edit.text.toString()
//                fos.write(data.toByteArray()) //EditText에서읽은 데이터를 Byte타입의 배열로 변환해서 출력하기
//            fos.flush()
//            fos.close()
            val pw = PrintWriter(fos)
            pw.println(data)
            pw.flush()
            pw.close()
            file_edit.setText("")
        }
        //EditText에 입력한 값 저장한 데이터 읽어오기
        internal_fileopen2.setOnClickListener {
            val fis = openFileInput("myfile2.txt")
            fis.bufferedReader().forEachLine {
                fileTxt.append("$it \n")
            }
        }

    }
}