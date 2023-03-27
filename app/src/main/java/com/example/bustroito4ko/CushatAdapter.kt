package com.example.bustroito4ko

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bustroito4ko.databinding.CushatItemBinding
import layout.Cushat

class CushatAdapter: RecyclerView.Adapter<CushatAdapter.CushatHolder>() {
    val cushatList = ArrayList<Cushat>()
    class CushatHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = CushatItemBinding.bind(item)
        fun bind(cushat: Cushat) = with(binding){
            im.setImageResource(cushat.imageId)
            tvTitle.text = cushat.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CushatHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cushat_item, parent, false)
        return CushatHolder(view)
    }

    override fun onBindViewHolder(holder: CushatHolder, position: Int) {
        holder.bind(cushatList[position])
    }

    override fun getItemCount(): Int {
        return cushatList.size
    }

    fun addPlant(cushat: Cushat){
        cushatList.add(cushat)
        notifyDataSetChanged()
    }
}