package com.example.memberregistersqlitepro

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memberregistersqlitepro.databinding.ActivityListBinding
import com.example.memberregistersqlitepro.databinding.MemberRecyclerBinding

class ListActivity : AppCompatActivity() {
    lateinit var binding: ActivityListBinding
    lateinit var memberRecyclerAdapter: MemberRecyclerAdapter
    var memberDataList: MutableList<Member>? = mutableListOf<Member>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dbHelper: DBHelper = DBHelper(applicationContext, MainActivity.DB_NAME, MainActivity.VERSION)

        memberDataList = dbHelper.selectAll()

        memberRecyclerAdapter = MemberRecyclerAdapter(memberDataList!!)
        binding.recyclerView.adapter = memberRecyclerAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}