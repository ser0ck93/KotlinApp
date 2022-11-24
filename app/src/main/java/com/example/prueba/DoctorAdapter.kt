package com.example.prueba

import android.view.LayoutInflater
import android.view.View.OnCreateContextMenuListener
import android.view.ViewGroup
import android.view.ViewParent
import androidx.recyclerview.widget.RecyclerView
import com.example.prueba.databinding.ItemDoctorBinding
import java.lang.reflect.Type
import java.text.FieldPosition

class DoctorAdapter(var list: List<DoctorItemModel>):RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {

    var listener: OnDoctorClickListener? = null
    class ViewHolder(val item: ItemDoctorBinding): RecyclerView.ViewHolder(item.root)



    override fun onBindViewHolder(holder:ViewHolder,position: Int){
        val doctor = list[position]
        holder.item.itemDoctor1.text = doctor.name
        holder.item.itemDoctorSpecialist.text=doctor.speciality
        holder.item.descriptionDoctor1.text=doctor.caption
        holder.item.itemDoctorImage.setImageResource(doctor.image.toInt())
        holder.item.itemStar1.rating=(doctor.star/5.0).toFloat()
        holder.item.root.setOnClickListener {
            listener?.onClick(doctor)
        }
    }

    override fun getItemCount(): Int {
        return list.size

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDoctorBinding.inflate(inflater,parent,false))
    }
fun updateDataset(list:List<DoctorItemModel>){
    this.list = list
    notifyDataSetChanged()
}

}