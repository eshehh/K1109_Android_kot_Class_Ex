package com.example.test11

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.test11.databinding.ActivityViewPagerTestBinding
import com.example.test11.databinding.ViewitemBinding



class ViewPagerTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager_test)

        // 바인딩 작업, 뷰 페이저2가 기본 화면, 여기에 데이터 항목들이 주입됨.
        val binding= ActivityViewPagerTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 부분은, 파이어베이스에서 데이터를 받아 오게 됨. or 스프링부트를 통해 데이터베이스와 연동해서
        // 임시 데이터
        val datas = mutableListOf<Int>()
        datas.add(R.drawable.lava)
        datas.add(R.drawable.spring)
        datas.add(R.drawable.kbo)
        datas.add(R.drawable.stadium)
//        for(i in 1..4){
//            datas.add("이미지 사진$i")
//        }
        binding.viewpager2.adapter=MyPagerAdapter(datas)
    }

    // 뷰 홀더 : 뷰 객체들을 모아주는 역할.
    // 주 생성자의 매개변수 : val binding: Item354Binding , 코드가 깔끔해지고 작업이, 편해짐.
    class MyPagerViewHolder(val binding: ViewitemBinding): RecyclerView.ViewHolder(binding.root)

    // 어댑터 : 뷰 객체에 데이터를 연결(바인딩)하는 작업
    // 주생성자의 매개변수 부분이 임의로 만든 리스트, 사실은 여기에 외부에서 데이터를 받아 올 예정.
    class MyPagerAdapter(val datas: MutableList<Int>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
        override fun getItemCount(): Int{
            return datas.size
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
                = MyPagerViewHolder(ViewitemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            // MyPagerViewHolder -> 뷰가 Item354Binding
            // Item354Binding.xml 파일안에 아이디가 -> item_Pager_TextView
            // 다시, 바인딩으로 해서 정의해서 선택해서 사용함.
            // -> itemPagerTextView
            val binding=(holder as MyPagerViewHolder).binding
            //뷰에 데이터 출력

            // 기존에 텍스트 뷰 -> 이미지 뷰로
//            binding.itemPagerImageView.setImageResource(R.drawable.lava)
//            binding.itemPagerImageView.setImageResource(R.drawable.spring)
//            binding.itemPagerImageView.setImageResource(R.drawable.kbo)
//            binding.itemPagerImageView.setImageResource(R.drawable.stadium)

            binding.itemPagerImageView.setImageResource(datas[position])
            when(position % 4){
                0 -> binding.itemPagerImageView.setBackgroundColor(Color.RED)
                1 -> binding.itemPagerImageView.setBackgroundColor(Color.BLUE)
                2 -> binding.itemPagerImageView.setBackgroundColor(Color.GREEN)
                3 -> binding.itemPagerImageView.setBackgroundColor(Color.BLACK)
            }
        }
    }
}