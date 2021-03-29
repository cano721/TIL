package com.example.fragment.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.R

class FirstFragment :Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("lifecycle","Fagement:::::::oncreate()")
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        Log.d("lifecycle","Fagement:::::::onAttach()")
        super.onAttach(context)
    }

    //fragment가 뷰를 만들때 호출되는 메소드
    //액티비티에 배치될때 호출된다. - 프래그먼트에 보여질 뷰를 그리기 위해서 호출하는 메소드
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("lifecycle","Fagement:::::::oncreateView()")
        val view = inflater.inflate(R.layout.fragment_first2,container,false)
        return view
    }
    //Layout을 구성하는 각 요소가 실제 뷰객체를 참조할때 호출
    //xml에 정의되어 있는 변수에 각각 뷰객체가 할당되는 시점
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("lifecycle","Fagement:::::::onViewCreated()")
    }
    //액티비티에서 보여줄 fragment가 완전히 생성이 완료되면 호출
    //onViewCreated는 보여질 요소들을 만드는 과정이고 onActivityCreated는 통제하기 위해서 가능한 시점이라는 것을 의미
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("lifecycle","Fagement:::::::onActivityCreated()")
    }
    //fragment가 시작될 때 - 사용자가 fragment를 볼 수 있는 시점 (fragment가 화면에 표시될때 호출)
    override fun onStart() {
        super.onStart()
        Log.d("lifecycle","Fagement:::::::onStart()")
    }
    //완전히 다 보여지고 난 후에 호출 - 사용자와 상호작용이 가능한 상태
    override fun onResume() {
        super.onResume()
        Log.d("lifecycle","Fagement:::::::onResume()")
    }
    //fragment가 일시정지될때 - fragment를 다른 액티비티나 fragment가 가리기 시작할때 호출
    override fun onPause() {
        super.onPause()
        Log.d("lifecycle","Fagement:::::::onPause()")
    }
    //fragment가 화면에서 완전히 안보일때 - 지워지는 것은 그냥 화면에서 안 보이는 것이다.
    override fun onStop() {
        super.onStop()
        Log.d("lifecycle","Fagement:::::::onStop()")
    }
    //fragment에서 뷰를 지우기 - fragmnet가 제거되는 시점
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("lifecycle","Fagement:::::::onDestroyView()")
    }
    //액티비티가 화면에서 없어질때 호출
    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle","Fagement:::::::onDestroy()")
    }
    //fragment와 액티비이틔 연결이 완전히 끊어질때 발생
    override fun onDetach() {
        super.onDetach()
        Log.d("lifecycle","Fagement:::::::onDetach()")
    }
}