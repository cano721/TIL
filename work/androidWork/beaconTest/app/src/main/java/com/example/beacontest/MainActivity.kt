package com.example.beacontest

import android.Manifest
import android.content.pm.PackageManager
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.altbeacon.beacon.*
import java.util.ArrayList
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), BeaconConsumer {
    //비콘 관련 변수
    private var beaconManager: BeaconManager? = null
    var beaconDistance: Float = 0f
    // 감지된 비콘들을 임시로 담을 리스트
    private val beaconList: MutableList<Beacon> = ArrayList()

    lateinit var beaconHandler : Handler
    //권한 상태
    private var permission_state = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1. Permission(권한)을 먼저 체크 - 위치기능권한(ACCESS_COARSE_LOCATION,ACCESS_FINE_LOCATION), 블루투스기능 권한

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH) != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADMIN) != PackageManager.PERMISSION_GRANTED
        ) {
            //2. 권한이 없는 경우 권한을 설정하는 메시지를 띄운다.
            permission_state = false
            ActivityCompat.requestPermissions(
                    this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION),
                    1000)
        } else {
            permission_state = true
//            printToast("권한 확인완료")
            //provider 를 가져올 수 있는 function call
            Log.d("Beacon", "권한 확인완료")
        }
        //비콘 기능 핸들러 설정
        // 실제로 비콘을 탐지하기 위한 비콘매니저 객체를 초기화
        beaconManager = BeaconManager.getInstanceForApplication(this)

        // 여기가 중요한데, 기기에 따라서 setBeaconLayout 안의 내용을 바꿔줘야함
        // ibeacon의 경우 아래와 같이 설정
        beaconManager!!.beaconParsers
                .add(BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"))

        // 비콘 탐지를 시작한다. 실제로는 서비스를 시작하는것.
        beaconManager!!.bind(this)

        beaconHandler = object : Handler(Looper.myLooper()!!) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                Log.d("beacon", "핸들러 진입 / beaconList.size: ${beaconList.size}msg:${msg}")

//                textView.text = ""

                // 비콘의 아이디와 거리를 측정하여 textView에 넣는다.
                for (beacon in beaconList) {
                    Log.d("beacon", "포문 진입 $beaconDistance")
                    beaconDistance = (beacon.distance * 10).roundToInt() / 10f
//                    textView.append(
//                            "ID : " + beacon.id2 + " / " + "Distance : " + String.format(
//                                    "%.3f",
//                                    beacon.distance
//                            ).toDouble() + "m\n"
//                    )
                }
                // 자기 자신을 1초마다 호출
                this.sendEmptyMessageDelayed(0, 1000)
            }
        }
        beaconHandler.sendEmptyMessage(0)
    }
    override fun onBeaconServiceConnect() {
        beaconManager!!.removeAllRangeNotifiers()
        beaconManager!!.addRangeNotifier(object : RangeNotifier {
            override fun didRangeBeaconsInRegion(beacons: MutableCollection<Beacon>?, region: Region?) {
                // 비콘이 감지되면 해당 함수가 호출된다. Collection<Beacon> beacons에는 감지된 비콘의 리스트가,
                // region에는 비콘들에 대응하는 Region 객체가 들어온다.
                Log.d("beacon", "addRangeNotifier 진입, 사이즈: ${beacons!!.size}")
                if (beacons!!.size > 0) {
                    Log.d("beacon", "비콘 감지 OK, size:${beacons!!.size}")
                }
                if (beacons.size > 0) {
                    beaconList.clear()
                    for (beacon in beacons) {
                        beaconList.add(beacon)
                    }
                }
            }
        })

        try{
            Log.d("beacon", "비콘매니저 monitor실행")
            beaconManager!!.startRangingBeaconsInRegion(
                    Region(
                            "myRangingUniqueId",
                            null,
                            null,
                            null
                    )
            )
        } catch (e: RemoteException) {
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        beaconManager!!.unbind(this)
    }
    //권한 설정창이 끝나면
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String?>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1000 && grantResults.size > 0) { //권한 처리 결과를 확인하고 요청한 요청 코드가 맞으면
            var check_result = true
            permission_state = true
            for (result in grantResults) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    check_result = false;
                    break;
                }
            }
            if (check_result != true) {
                Toast.makeText(this, "권한 설정이 거부되었습니다.\n설정에서 권한을 허용해야 합니다..", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "권한 설정이 되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}