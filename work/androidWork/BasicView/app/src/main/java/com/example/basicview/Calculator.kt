package com.example.basicview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_calculator.*

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        var history:String = ""
        var num1:String = ""
        var num2:String = ""
        resultCalc2.setText("0")
        resultCalc.setText("")
        var double1:Double
        var double2:Double
        //초기화부분
        CE.setOnClickListener {
            resultCalc.setText("")
            resultCalc2.setText("0")
            double1 = 0.0
            double2 = 0.0
            history = ""
            num1 = ""
            num2 = ""
        }
        C.setOnClickListener {
            resultCalc.setText("")
            resultCalc2.setText("0")
            double1 = 0.0
            double2 = 0.0
            history = ""
            num1 = ""
            num2 = ""
        }
        //부호 바꾸는 부분
//        plusAndMinus.setOnClickListener {
//            if((Double.parse))
//        }
        var btnArr = arrayOf(plus,minus,multiplation,division,value,DEL)
        for(i in btnArr){
            i.setOnClickListener{}
        }
        for (i in 0..9) {
            var checkString: String = "number" + "$i"
            var chBoxId = resources.getIdentifier(checkString, "id", packageName)
            findViewById<Button>(chBoxId).setOnClickListener {
                if (resultCalc2.text.indexOf("0") == 0) {
                    resultCalc2.setText("$i")
                } else {
                    resultCalc2.append("$i")
                }
            }
        }

//        var reg = Regex("[0-9]*")
//        for (i in 0..9) {
//            var checkString: String = "number" + "$i"
//            var chBoxId = resources.getIdentifier(checkString, "id", packageName)
//            findViewById<Button>(chBoxId).setOnClickListener {
//                if (resultCalc2.text.indexOf("0") == 0) {
//                    resultCalc2.setText("$i")
//                } else {
//                    resultCalc2.append("$i")
//                }
//            }
//        }
//        CE.setOnClickListener {
//            resultCalc2.setText("0")
//        }
//        C.setOnClickListener {
//            resultCalc.setText("")
//            resultCalc2.setText("0")
//        }
//        for(i in btnArr){
//            var onGoingText: String = resultCalc2.text.toString()
//            var resultText: String = resultCalc.text.toString()
//            var ran = resultText.length
//            i.setOnClickListener { if (resultCalc.text == "") {
//                resultCalc.text = resultCalc2.text
//                } else {
//                if ((onGoingText.matches(reg))) {
//                    if(resultText.substring(ran-1,ran)=="＋") {
//                        resultCalc.text = (resultText.substring(0,ran-1).toDouble() + onGoingText.toDouble()).toString()
//                        }
//                    else if(resultText.substring(ran-1,ran)=="×"){
//                        resultCalc.text = (resultText.substring(0,ran-1).toDouble() * onGoingText.toDouble()).toString()
//                        }
//                    else if(resultText.substring(ran-1,ran)=="÷"){
//                        resultCalc.text = (resultText.substring(0,ran-1).toDouble() / onGoingText.toDouble()).toString()
//                        }
//                    else if(resultText.substring(ran-1,ran)=="－"){
//                        resultCalc.text = (resultText.substring(0,ran-1).toInt() - onGoingText.toInt()).toString()
//                        }
//                    else if(resultText.substring(ran-1,ran)=="＝"){
//                        resultCalc.text = (resultText.substring(0,ran-1).toInt() - onGoingText.toInt()).toString()
//                        }
//                    }
//                }
//
//            when(i){
//                plus -> resultCalc.append("＋")
//                minus -> resultCalc.append("－")
//                multiplation -> resultCalc.append("×")
//                division -> resultCalc.append("－")
//                value -> resultCalc.append("＝")
//            }
//            }
//            }
        }
    }




