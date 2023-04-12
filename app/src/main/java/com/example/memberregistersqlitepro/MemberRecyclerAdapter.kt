package com.example.memberregistersqlitepro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.memberregistersqlitepro.databinding.MemberRecyclerBinding

class MemberRecyclerAdapter(val memberList: MutableList<Member>) : RecyclerView.Adapter<MemberRecyclerAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = MemberRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int = memberList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = holder.binding
        binding.imgUser.setImageResource(R.drawable.person_24)
        binding.tvName.text = memberList.get(position).name.toString()
        binding.tvId.text = memberList.get(position).id.toString()
        binding.tvPhone.text = memberList.get(position).phone.toString()
    }

    inner class CustomViewHolder(val binding: MemberRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root)
}