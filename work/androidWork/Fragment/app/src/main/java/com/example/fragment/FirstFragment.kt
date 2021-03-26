package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("lifecycle","Fagement:::::::onViewCreated()")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("lifecycle","Fagement:::::::onActivityCreated()")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle","Fagement:::::::onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle","Fagement:::::::onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle","Fagement:::::::onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle","Fagement:::::::onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("lifecycle","Fagement:::::::onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle","Fagement:::::::onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("lifecycle","Fagement:::::::onDetach()")
    }
}