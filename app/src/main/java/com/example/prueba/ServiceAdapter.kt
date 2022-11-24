package com.example.prueba

import android.location.GnssAntennaInfo.Listener
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.ItemServiceBinding



class ServiceAdapter(val list : List<ServiceitemModel>): RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    var listener: OnServiceClickListener? = null

    class ViewHolder(val item:ItemServiceBinding):RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemServiceBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val service = list[position]
        holder.item.itemServiceTitle.text = service.title
        holder.item.itemServiceDescription.text = service.description
        holder.item.itemServiceIcon.setImageResource(service.icon.toInt())
        holder.item.root.setOnClickListener{
            listener?.onClick(service)
        }    }

    override fun getItemCount(): Int {
        return list.size
    }
}