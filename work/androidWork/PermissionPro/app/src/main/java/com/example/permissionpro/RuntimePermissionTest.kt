package com.example.permissionpro

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_runtime_permission_test.*

class RuntimePermissionTest : AppCompatActivity() {
    //퍼미션의 상태를 저장할 수 있는 변수
    var permission_state:Boolean = false
    //퍼미션용 배열 정의
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_runtime_permission_test)
        //퍼미션이 배열인 경우 for 문 체크
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED){
            permission_state = true
            printToast("권한이 설정되어 있습니다.")
        }
        else{
            permission_state = false
            //2. 권한이 설젇되어 있지 않은 경우 메시지를 출력
            //   권한이 설정하는 메시지를 띄운다.
            printToast("권한을 설정해야 합니다.")
            ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA),1000)

        }
        run_camera.setOnClickListener {
            if(permission_state) {
                val myintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(myintent, 30)
            }else{
                printToast("권한을 설정해야만 이 기능을 사용할 수 있습니다.")
            }
        }
    }
    //3. requestPermissions의 권한설정 창에서 권한을 설정한 후 호출되는 메소드
    //   결과를 리턴 - 결과에 따라서 다르게 처리할 수 있도록 구현
    //   requestCode - requestPermissions 호출하면서 넘긴 requestCode
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //퍼미션이 여러 개인 경우 for문
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            permission_state = true
            printToast("권한 설정 마무리 완료")
        }else{
            printToast("권한 설정을 하지 않으면 이 기능을 사용할 수 없습니다.")
            //설정 액티비티로 이동
        }
    }
    fun printToast(msg:String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}