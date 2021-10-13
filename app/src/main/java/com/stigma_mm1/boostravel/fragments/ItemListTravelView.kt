package com.stigma_mm1.boostravel.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.stigma_mm1.boostravel.ListTravelActivity
import com.stigma_mm1.boostravel.R
import com.stigma_mm1.boostravel.adapter.ListTravelRecyclerViewAdapter
import com.stigma_mm1.boostravel.adapter.dummy.DummyContent
import com.stigma_mm1.boostravel.data.Travel
import kotlinx.android.synthetic.main.fragment_item_list_travel_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class ItemListTravelView : Fragment() {
//	lateinit var adapterListTravel: ListTravelRecyclerViewAdapter
	var listTravel = ArrayList<Travel>()
	
	private var columnCount = 1
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
	}
	
	override fun onCreateView(
			inflater: LayoutInflater, container: ViewGroup?,
			savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.fragment_item_list_travel_list, container, false)
		
		// Set the adapter
		if (view is RecyclerView) {
			with(view) {
				layoutManager = when {
					columnCount <= 1 -> LinearLayoutManager(context)
					else -> GridLayoutManager(context, columnCount)
				}
//                adapterListTravel = ListTravelRecyclerViewAdapter(listTravel, this)
				println("Apasih isi dari dummycontent ITEM = ${DummyContent.ITEMS}")
			}
		}
		return view
	}
}