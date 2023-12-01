package com.faqiy.kokikreatif

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.faqiy.kokikreatif.databinding.ItemResepBinding
import com.squareup.picasso.Picasso

class ResepAdapter : RecyclerView.Adapter<ResepAdapter.ResepViewHolder>(){

    private var listResep = arrayListOf<resep>()

    fun setData(list: List<resep>?){
        if (list == null) return
        listResep.clear()
        listResep.addAll(list)
    }

    inner class ResepViewHolder (val binding: ItemResepBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ResepViewHolder (
        ItemResepBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun getItemCount(): Int = listResep.size

    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
        val data = listResep[position]
        holder.binding.apply {
            itemTitle.text = data.nama
            itemDescription.text = data.kesimpulan
            Picasso.get().load(data.img).into(itemImage)
        }

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context,DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA,data)
            it.context.startActivity(intent)
        }

    }

}