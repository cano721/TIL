package com.example.intent

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.PermissionChecker

class ImplicitActivity : AppCompatActivity() {
    //이 앱을 이용하면서 승인할 위험 권한의 목록
    val permission_list = arrayOf(android.Manifest.permission.CALL_PHONE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_app_run)

        //권한을 체크할 수 있는 메소드
        runPermission()
    }
    //권한을 체크 - 승인처리
    fun runPermission(){
        //하위버전이면 실행되지 않도록 설정
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return // 메소드 실행하지않고 종료
        }
        //권한의 셀프체크
        for(permission in permission_list){
            //권한이 이미 부여되어 있는지 확인
            val chk = checkCallingOrSelfPermission(permission)
            //권한이 부여되지 않았으면
            if(chk == PackageManager.PERMISSION_GRANTED){
                //권한부여 요청 대화상자를 실행해준다. -사용자가가 권한승인을 접하지만 대화상자는 시스템이 실행한다.
                requestPermissions(permission_list,0)
                break
            }
        }
    }
    //전화거는 것은 요금이 나가고 개인정보와 관련된 부분이 있으므로 사용할 수 있는 권한을 체크해야 한다.
    //권한을 승인받는 처리깢 ㅣ해주어야 한다.
    //안드로이드 6(API 23)버전부터는 권한을 일반권한과 위험권한으로 나누어서 관리
    //기존방식은 앱을 설치하는 시점에만 권한에 대한 승인을 체크하는 방식이었으나
    //권한들이 단말기의 주요한 기능을 사용할 수 있어서 위험권한으로 분류된 권한은
    //앱을 설치할때가 아니라 사용할때 권한을 승인하도록 변경
    fun runCallPhone(v:View){
        var uri = Uri.parse("tel:01039250250")
        var imintent:Intent? = null
        val check = PermissionChecker.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
        if(check==PackageManager.PERMISSION_GRANTED){
            var imintent = Intent(Intent.ACTION_CALL,uri)
        }else {
            return
        }
        startActivity(imintent)
    }
    fun runDial(v:View){
        var uri = Uri.parse("tel:01039250250")
        var imintent = Intent(Intent.ACTION_DIAL,uri)
        startActivity(imintent)
    }

    fun runWeb(v:View){
        var uri = Uri.parse("http://m.daum.net")
        var imintent = Intent(Intent.ACTION_VIEW,uri)
        startActivity(imintent)
    }
    //안드로이드의 기본 앱을 암시적인텐트를 이용해서 실행
    //안드로이드 내부에서 알 수 있는 기본 액션명을 이용해서 실행
    //action과 실행할 데이터의 형식 즉, 유형이 어떤 것인지 같이 정의
    //data는 이 앱에서 허용된 데이터으 ㅣ유형 - URI나 MIME유형을 이용하여 정의
    //geo로 시작을 하면 맵을 실행해야겠다고 내부에서 판단
    fun runGoogleMap(v: View){
        //실행할 data
        var uri = Uri.parse("geo:37.48233169298042, 127.05011032619656")
        //인텐트가 인식할 action명을 주고 인텐트객체생성
        //ACTION_VIEW는 뭔가를 보여주는 목적으로 실행되는 앱에 줄 수 있는 action명
        //ACTION_VIEW라는 이름을 안드로이드OS에게 요청하면 미리 정리해 둔 컴포넌트 목록에서
        //ACTION_VIEW라는 이름으로 등록된 모든 뷰를 찾아서 보여준다.
        var imintent = Intent(Intent.ACTION_VIEW,uri)
        startActivity(imintent)
    }
}