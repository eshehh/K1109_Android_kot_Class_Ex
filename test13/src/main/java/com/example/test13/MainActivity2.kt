package com.example.test13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.test13.databinding.ActivityDetailBinding
import com.example.test13.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("kkang", "MainActivity2..onCreate..........")
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // 메인 액티비티에서 넘어온 값을 , 값을 가지고 오는 부분
        val ID1 = intent.getStringExtra("ID1")
        val PW1 = intent.getStringExtra("PW1")

        binding.main2ResultView.text = "ID1: $ID1, PW1: $PW1"
    }
}