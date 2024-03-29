package com.example.ch18_network_test

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch18_network_test.databinding.ActivityMainBinding
import com.example.ch18_network_test.model.PageListModel
import com.example.ch18_network_test.recycler.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val serviceKey = "7I1PLTmdTXyFRymfi7Ul6qSGLd9U3l3mgaPasGqpYNw3hFgf1ofCdvODEhHMZN2Y"

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val networkService = (applicationContext as MyApplication).networkService

        val userListCall = networkService.getList(serviceKey,1)
        Log.d("lsy", "url:" + userListCall.request().url().toString())

        userListCall.enqueue(object : Callback<PageListModel> {
            override fun onResponse(call: Call<PageListModel>, response: Response<PageListModel>) {

                val userList = response.body()
                Log.d("lsy","userList data 값 : ${userList?.body}")
                //.......................................

                binding.recyclerView.adapter= MyAdapter(this@MainActivity, userList?.body)

                binding.recyclerView.addItemDecoration(
                    DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL)
                )

//                binding.pageView.text=userList?.page
//                binding.totalView.text=userList?.total
            }

            override fun onFailure(call: Call<PageListModel>, t: Throwable) {
                call.cancel()
            }
        })



    }
}