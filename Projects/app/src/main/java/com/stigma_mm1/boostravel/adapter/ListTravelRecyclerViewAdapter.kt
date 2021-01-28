package com.stigma_mm1.boostravel.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stigma_mm1.boostravel.R

import com.stigma_mm1.boostravel.adapter.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ListTravelRecyclerViewAdapter(private val values: List<DummyItem>)
  : RecyclerView.Adapter<ListTravelRecyclerViewAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.fragment_item_list_travel, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//    holder.bind(myData)
//    holder.itemView.setOnClickListener {
//      val moveWithObjectIntent = Intent(context, pesanan::class.java)
//      moveWithObjectIntent.putExtra(pesanan.EXTRA_MYDATA, myData)
//      context.startActivity(moveWithObjectIntent)
//    }
  }

  override fun getItemCount(): Int = values.size

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//    fun bind(myData: MyData) {
//      with(itemView){
//        Glide.with(itemView.context)
//          .load(myData.photo)
//          .apply(RequestOptions().override(55, 55))
//          .into(img_item_photo)
//        tv_item_name.text = myData.name
//        tv_item_description.text = myData.description
//      }
//    }
  }
}