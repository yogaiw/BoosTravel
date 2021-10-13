package com.stigma_mm1.boostravel.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.stigma_mm1.boostravel.R

import com.stigma_mm1.boostravel.adapter.dummy.DummyContent.DummyItem
import com.stigma_mm1.boostravel.data.Travel
import com.stigma_mm1.boostravel.fragments.ItemListTravelView
import kotlinx.android.synthetic.main.fragment_item_list_travel.view.*

class ListTravelRecyclerViewAdapter(var context: Context)
    : RecyclerView.Adapter<ListTravelRecyclerViewAdapter.ViewHolder>() {
    
    var listTravel = ArrayList<Travel>()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_list_travel, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listTravel[position])
    }

    override fun getItemCount(): Int = listTravel.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(travel: Travel) {
            with(itemView){
                // Glide.with(itemView.context)
                //    .load(travel.logoTravel)
//                    .apply(RequestOptions().override(55, 55))
                //    .into(logoTravel)
                estimasiRute.text = travel.estimasiRute
                totalJalan.text = travel.totalJalan
                namaTravel.text = travel.namaTravel
                rutePerjalanan.text = travel.rutePerjalanan
                txtHarga.text = travel.hargaPerjalanan
            }
            
        }
    }
}