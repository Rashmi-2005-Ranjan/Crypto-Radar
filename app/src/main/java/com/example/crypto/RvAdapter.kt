package com.example.crypto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.databinding.RvItemBinding

class RvAdapter(val context: Context, var data:ArrayList<Model>) : RecyclerView.Adapter<RvAdapter.Viewholder>(){

    inner class Viewholder(val binding: RvItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val view=RvItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return Viewholder(view)
    }



    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        setAnimation(holder.itemView)
        holder.binding.Name.text=data[position].name
        holder.binding.Symbol.text=data[position].Symbol
        holder.binding.Price.text=data[position].Price

    }
    override fun getItemCount(): Int {
        return data.size
    }
   fun setAnimation(view: View){
       val anim=AlphaAnimation(0.0f,1.0f)
       anim.duration=1000
       view.startAnimation(anim)
   }

    fun changeData(filterdata: ArrayList<Model>) {

        data=filterdata
        notifyDataSetChanged()
    }
}