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
        var a: String = ""
        var list = mutableListOf<String>()
        var b: Long = 0L
        var c: Long = 1L
        var d: Double = 1.0


        //번호 입력 부분
        for (i in 0..9) {
            var checkString: String = "number" + "$i"
            var chBoxId = resources.getIdentifier(checkString, "id", packageName)
            findViewById<Button>(chBoxId).setOnClickListener {
                resultCalc.setText(resultCalc.getText().append("$i"))
                a = resultCalc.getText().toString()
            }
        }

        //연산자 입력 부분

        var btnArr = arrayOf(plus, minus, multiplation, division)
        for (i in btnArr) {
            i.setOnClickListener {
                resultCalc.setText(resultCalc.getText().append("${i.text}"))
                a = resultCalc.getText().toString()
            }
        }

        value.setOnClickListener {
            b = 0
            c = 1
            d = 1.0
            if (list.size != 0) {
                list = mutableListOf<String>()
            }

            if (resultCalc.getText().contains("+")) {
                val str = resultCalc.getText().split("+")
                val a = str[0].toDouble()
                val z = a.toInt()
                for (i in 0..str.size - 1) {
                    if (i == 0) {
                        list.add(z.toString())
                        b += list.get(i).toInt()
                    } else {
                        list.add(str[i])
                        b += list.get(i).toInt()
                    }

                }

                resultCalc.setText(String.format("%d", b))
            }

            if (resultCalc.getText().contains("-")) {
                val str = resultCalc.getText().split("-")
                val a = str[0].toDouble()
                val z = a.toLong()
                b = z
                for (i in 0..str.size - 1) {
                    list.add(str[i])
                    if (i != 0) {
                        b -= list.get(i).toInt()

                    }
                }

                resultCalc.setText(String.format("%d", b))
            }

            if (resultCalc.getText().contains("*")) {
                val str = resultCalc.getText().split("*")
                val a = str[0].toDouble()
                val z = a.toInt()

                for (i in 0..str.size - 1) {
                    if (i == 0) {
                        list.add(z.toString())
                        c *= list.get(i).toInt()
                    } else {
                        list.add(str[i])
                        c *= list.get(i).toInt()
                    }

                }
                resultCalc.setText(String.format("%d", c))
            }

            if (resultCalc.getText().contains("/")) {
                val str = resultCalc.getText().split("/")
                d = str[0].toDouble()
                for (i in 0..str.size - 1) {
                    list.add(str[i])
                    if (i != 0) {
                        d /= list.get(i).toDouble()

                    }
                }

                resultCalc.setText(String.format("%.3f", d))
            }
            C.setOnClickListener {
                resultCalc.setText("")
            }
        }
    }
}
//
//        //부호 바꾸는 부분
//
//        for(i in btnArr){
//            i.setOnClickListener {
//                if (opr.toString() == "") {
//                    resultCalc.text = ""
//                    num1 = resultCalc2.text.toString()
//                    opr = i.text.toString()
//                    resultCalc.setText("${resultCalc2.text.toString() + "${i.text}"}")
//                } else {
//                    resultCalc.text = ""
//                    num2 = resultCalc2.text.toString()
//                    var result = 0.0
//                    when (opr) {
//                        "＋" -> result = num1.toDouble() + num2.toDouble()
//                        "－" -> result = num1.toDouble() - num2.toDouble()
//                        "×" -> result = num1.toDouble() * num2.toDouble()
//                        "÷" -> result = num1.toDouble() / num2.toDouble()
//                        else -> result = num1.toDouble()
//                    }
//                    resultCalc.setText("${result.toString()}+${i.text}")
//                }
//            }
//        }
//    }
//}

//        var btnArr = arrayOf(plus,minus,multiplation,division,value,DEL)
//        for(i in btnArr){
//            i.setOnClickListener{}
//        }

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



