package com.example.intent.exam

import android.content.Context
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.os.persistableBundleOf

class ExamAdapter(context: Context,var resId:Int,var datalist:ArrayList<Person>):ArrayAdapter<Person>(context,resId,datalist) {

    var saveData = HashMap<Int,Boolean>()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //뷰 만들기(재사용 가능)
        var row_view = convertView
        var holder: ViewHolder? = null
       // Log.d("getView","${datalist.toString()}:${datalist.size}")
        if (row_view == null){
            val inflator =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            row_view = inflator.inflate(resId, null)
            holder = ViewHolder(row_view)
            row_view.tag = holder
        } else {
            holder = row_view.tag as ViewHolder
        }


        //데이터 연결부
        val person = datalist[position] //상속받은 데이터리스트중 position번째 해당하는것
        if (person != null){ //데이터가 있으면
            val imageView = holder.myImg
            val nameView = holder.nameView
            val dateView = holder.dateView
            val checkBox_nameview = holder.checkBox_nameView
            val checkBox = holder.checkBox

            imageView?.setImageResource(person.myImg)
            nameView?.text = person.name
            dateView?.text = person.date
            checkBox_nameview?.text = person.checkBox_name


            //체크박스 선택여부에 따른 표기
            var state = saveData[position]
            if(state == null){
                checkBox?.isChecked = false
            }else{
                checkBox?.isChecked = state
            }

            //체크박스 선택했냐 안했냐 확인
            checkBox?.setOnClickListener {
                if(saveData[position]==null){
                    saveData[position] = true
                }else{
                    saveData.remove(position)
                }
            }

        }

        return row_view!!
    }


    //매개변수로 전달받은 순서에 있는 리스트 한 항목을 반환
    override fun getItem(position: Int): Person? {
        return datalist.get(position)
    }

    //리스트갯수를 반환
    override fun getCount(): Int {
        return datalist.size
    }
}