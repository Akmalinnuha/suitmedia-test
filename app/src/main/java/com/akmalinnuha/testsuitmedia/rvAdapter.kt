package com.akmalinnuha.testsuitmedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class rvAdapter(private val data_items: ArrayList<item_data.Students>): RecyclerView.Adapter<rvAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvEmail: TextView = itemView.findViewById(R.id.tv_email)
        var tvFirstName: TextView = itemView.findViewById(R.id.tv_firstName)
        var tvLastName: TextView = itemView.findViewById(R.id.tv_lastName)
        var img: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_name, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val roster = data_items[position]
        Glide.with(holder.itemView.context)
            .load(R.drawable.ic_launcher_background)
            .apply(RequestOptions().override(55, 55))
            .into(holder.img)
        holder.tvEmail.text = roster.email
        holder.tvFirstName.text = roster.first_name
        holder.tvLastName.text = roster.first_name
    }

    override fun getItemCount(): Int {
        return data_items.size
    }

    fun setdata(data: ArrayList<item_data.Students>) {
        data_items.clear()
        data_items.addAll( data )
        notifyDataSetChanged()
    }
}