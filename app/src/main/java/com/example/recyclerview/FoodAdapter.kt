package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ListItemBinding

class FoodAdapter(private val foodList: ArrayList<FoodsData>):RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {
    var onClick:((FoodsData) -> Unit)?= null
    class MyViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: FoodAdapter.MyViewHolder, position: Int) {
        val foods = foodList[position]
        holder.binding.apply {
            foodName.text = foods.foodName
            foodTitle.text = foods.foodTitle
            profileImage.setImageResource(foods.foodImages)
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(foods)
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }


}