package com.example.test13

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.test13.databinding.ActivityLoginBinding



class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id1 = binding.ID1.text.toString()
        val pw1 = binding.PW1.text.toString()

        binding.b1.setOnClickListener {
            val id1 = binding.ID1.text.toString()
            val pw1 = binding.PW1.text.toString()

            val intent: Intent = Intent(this, MainActivity2::class.java)
            // 데이터 같이 전달
            intent.putExtra("ID1", id1)
            intent.putExtra("PW1", pw1)
            startActivity(intent)
        }

    }
}