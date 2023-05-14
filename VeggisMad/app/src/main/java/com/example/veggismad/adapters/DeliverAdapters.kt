package com.example.veggismad.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.veggismad.R
import com.example.veggismad.models.DeliveryModel

class DeliverAdapters (private val deliveryList: ArrayList<DeliveryModel>) : RecyclerView.Adapter<DeliverAdapters.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.delivey_list_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentDelivery = deliveryList[position]
        holder.readName.text = currentDelivery.nameADD
    }

    override fun getItemCount(): Int {
        return deliveryList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val readName : TextView = itemView.findViewById(R.id.deliveryName)

    }



}
