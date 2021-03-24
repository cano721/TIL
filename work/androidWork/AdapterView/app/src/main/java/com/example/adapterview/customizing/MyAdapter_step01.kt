package com.example.adapterview.customizing

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.adapterview.R
import kotlinx.android.synthetic.main.custrow.view.*
//=====================커스터마이징해서 결과 출력되고 뷰 하나하나를 제어가 가능하도록 ==================
/*
나만의 어댑터를 작성
처음부터 끝까지 모두 만들 수 없기 때문에 기존에 제공되는 클래스 중 하나를 선택해서
상속을 받고 적절하게 재정의
 */
/*
MyAdapter를 생성할 때 어댑터 구현을 위해서 필요한 정보를 전달받을 수 있도록 정의
Context, row를 디자인하기 위한 xml리소스, 핸들링할 데이터
뷰를 만드는 과정을 재정의할뿐 내부에서 리스트뷰와 결합해서 만드는 과정 등은 개발자가
직접 만들기 어려움이 있으므로 반드시 기존 어댑터를 상속해서 작성한다.
 */

class MyAdapter_step01(context: Context, var resId:Int, var datalist:ArrayList<User>):ArrayAdapter<User>(context,resId,datalist) {

    /*
    ArrayAdapter가 갖고 있는 메소드를 재정의해서 ArrayAdapter의 메소드가 호출되며 row가 만들어지는 대신
    내가 원하는 방식대로 row가 만들어지도록 구현
 */
    //리스트의 한 항목이 만들어질때 호출되는 메소드
    /*
        리스트 항목이 100개면 100번 호출되는 메소드 - 한꺼번에 100개가 호출되는 것이 아니라 화면에 보이는 만큼만 호출된다.
        position -> 현재 만들고 있는 항목의 번호
        convertView -> 재사용할 row 뷰로 스크롤을 하고 나면 뷰가 안보이는데 그냥 버리는게 아니라 getView를 호출하며
                        전달, 이 convertView를 재사용할 수 있다.
        parent -> 상위뷰
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var start = System.nanoTime() //현재시간 측정

        //뷰를 생성하기 위해서 convertview를 활용 -화면을 만들기(LayoutInflater를 이용해서 직접 생성)
        val inflator = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var row_view = convertView
        row_view = inflator.inflate(resId,null) // inflate는 오버로딩되어 있으므로 필요한 것을 선택해서 작업

        //만들어진 row뷰를 구성하는 구성요소를 findViewById 해서 찾아옴 - why? (데이터 연결하려고)
        val imageView = row_view.findViewById<ImageView>(R.id.myimg)
        val nameView = row_view.findViewById<TextView>(R.id.txtcust1)
        val telNumView = row_view.findViewById<TextView>(R.id.txtcust2)
        val btnView = row_view.findViewById<Button>(R.id.btncust)

        //찾아온 뷰에 각각 데이터를 연결 - 데이터는 ArrayList에 각 정보가 User객체로 담겨있음
        //데이터를 뷰에 연결하기 전에 각 항목에 대한 데이터를 ArrayList에서 꺼내오기
        var user = datalist[position]
        imageView.setImageResource(user.myImg)
        nameView.text = user.name
        telNumView.text = user.telNum

        //이벤트 연결
        btnView.setOnClickListener {
            Log.d("getView","버튼이 눌려짐")
        }
        val end = System.nanoTime()
        Log.d("getView","getview()=====(실행시간:${end-start}.position:${position})")
        return row_view//android os가 실행되는 과정에서 getView를 호출하며 화면을 만들 수 있도록 리턴
    }

    //매개변수로 전달받은 순서에 있는 리스트 한 항목을 반환
   override fun getItem(position: Int): User? {
        return datalist.get(position)
    }

    //리스트갯수를 반환
    override fun getCount(): Int {
        return datalist.size
    }
}