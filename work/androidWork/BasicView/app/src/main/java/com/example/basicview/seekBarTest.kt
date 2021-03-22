package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_progress_bar_test.*
import kotlinx.android.synthetic.main.activity_seek_bar_test.*

class seekBarTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_test)
        seekbtngetValue.setOnClickListener {
            txtseekinfo1.text = "현재값:${seekBar.progress}"
            txtseekinfo2.text = "현재값:${seekBar2.progress}"
        }

        seekbtnset.setOnClickListener {
            seekBar.progress = 5
            seekBar2.progress = 5
        }
        seekbtnup.setOnClickListener {
            seekBar.incrementProgressBy(1)
            seekBar2.incrementProgressBy(1)
        }
        seekbtndown.setOnClickListener {
            seekBar.incrementProgressBy(-1)
            seekBar2.incrementProgressBy(-1)
        }

        //seekbar의 이벤트 처리 - seekbar의 값이 변경되었을때 이벤트 발생
        var listener1 = object : SeekBar.OnSeekBarChangeListener{
            //SeekBar의 값이 변경되었을때 호출
            //SeekBar - 값이 변경된 SeekBar 객체
            //progress - 값
            //fromUser - 사용자에 의해 변경되었는지 코드로 변경된 것인지 구분 : true(사용자) false(시스템)
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                when(seekBar?.id){
                    R.id.seekBar -> {
                        txtseekinfo1.text = "seekbar1의 현재값:${seekBar.progress}"
                    }
                    R.id.seekBar2 -> {
                    txtseekinfo2.text = "seekbar2의 현재값:${seekBar2.progress}"
                    }
                    }
                if(fromUser){
                    Toast.makeText(applicationContext,"사용자가 변경했습니다.",Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext,"코드로 변경했습니다.",Toast.LENGTH_LONG).show()
                }
            }
            //사용자가 터치를 시작했을때
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }
            //사용자가 터치를 끝났을때
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        }
        seekBar.setOnSeekBarChangeListener(listener1)
        seekBar2.setOnSeekBarChangeListener(listener1)
    }

}