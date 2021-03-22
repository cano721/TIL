package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
/*
    ImageView의 메소드
    1) setImageResource - res폴더에 있는 이미지 파일을 연결
    2) setImageBitmap
    3) setImageDrawable
        => setImageBitmap이나 setImageDrawable은 주로 파일이나 네트워크로 받은 이미지를 제어
        => setImageBitmap은 수정불가능, setImageDrawable은 수정 가능한 객체
 */
class ImageTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.image_test2)
    }
}