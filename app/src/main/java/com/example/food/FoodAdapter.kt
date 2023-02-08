package com.example.food

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.food.databinding.FoodItemsBinding

class FoodAdapter: ListAdapter<Food, RecyclerView.ViewHolder>(DIFF_CALLBACK){
 var s=20f
  private lateinit var mlistener: onItemClickListener
    interface onItemClickListener{
        fun onItemClick(Position: Int){

        }
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mlistener=listener
    }

companion object{
    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Food>() {

        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.name == newItem.name || oldItem.imageUrl == newItem.imageUrl
        }

    }
}
    private lateinit var binding: FoodItemsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = FoodItemsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding,mlistener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }

    inner class ViewHolder(val itemBinding: FoodItemsBinding,listener: onItemClickListener):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Food){

            itemBinding.tvName.textSize=s
            itemBinding.tvName.text = item.name
            itemBinding.ivAvatar.setImageResource(item.imageUrl)
        }
        init {
            itemBinding.food.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }


    }




}



