package com.stigma_mm1.boostravel.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.stigma_mm1.boostravel.R

import com.stigma_mm1.boostravel.adapter.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class PesananUserRecyclerViewAdapter(
  private val values: List<DummyItem>
) : RecyclerView.Adapter<PesananUserRecyclerViewAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.fragment_list_pesanan_user, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//    val item = values[position]
//    holder.idView.text = item.id
//    holder.contentView.text = item.content
  }

  override fun getItemCount(): Int = values.size

  inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//    val idView: TextView = view.findViewById(R.id.item_number)
//    val contentView: TextView = view.findViewById(R.id.content)
//
//    override fun toString(): String {
//      return super.toString() + " '" + contentView.text + "'"
//    }
  }
}