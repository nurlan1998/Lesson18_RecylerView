package com.example.lesson18_customdialog

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_number.view.*

class ListAdapter(var activity: MainActivity,var context: Context) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    var models: MutableList<PersonalArea> = mutableListOf()
    var selectedItem = 0

    fun setData(data: MutableList<PersonalArea>){
        models = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView: View =LayoutInflater.from(parent.context).inflate(R.layout.item_number,parent,false)
        return ListViewHolder(itemView,context)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.personalModel(models[position],position,activity)

    }

    inner class ListViewHolder(itemView: View,var context: Context) : RecyclerView.ViewHolder(itemView){

        fun personalModel(personalArea: PersonalArea,position: Int,activity: MainActivity){
            itemView.tvPersonalCount.text = personalArea.area
            itemView.tvPersonalCount.setOnClickListener {
                activity.selected(position)
                selectedItem = position
                notifyDataSetChanged()
            }
            if(selectedItem == position){
                itemView.tvPersonalCount.setBackgroundResource(R.drawable.ic_radio_button_unchecked_black_24dp)
            }else{
                itemView.tvPersonalCount.setBackgroundColor(Color.WHITE)
            }
        }
    }
}