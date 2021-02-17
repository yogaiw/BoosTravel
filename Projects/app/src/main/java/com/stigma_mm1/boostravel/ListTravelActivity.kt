package com.stigma_mm1.boostravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.stigma_mm1.boostravel.adapter.ListTravelRecyclerViewAdapter
import com.stigma_mm1.boostravel.data.Travel
import com.stigma_mm1.boostravel.fragments.ItemListTravelView
import kotlinx.android.synthetic.main.activity_list_travel.*
import kotlinx.android.synthetic.main.fragment_item_list_travel_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListTravelActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    private lateinit var mFirstFragment: ItemListTravelView

    private lateinit var adapter: ListTravelRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_travel)

        firestore = Firebase.firestore
        auth = Firebase.auth
        
        adapter = ListTravelRecyclerViewAdapter(this)

        val mFragmentManager = supportFragmentManager
        mFirstFragment = ItemListTravelView()
        val fragment = mFragmentManager.findFragmentByTag(ItemListTravelView::class.java.simpleName)
        if (fragment !is ItemListTravelView) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + ItemListTravelView::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.list_travel_container, mFirstFragment, ItemListTravelView::class.java.simpleName)
                .commit()
        }
        loadTravels()

    }

    private fun loadTravels() {
        GlobalScope.launch(Dispatchers.Main) {
            val travelList = ArrayList<Travel>()

            val currentUser = auth.currentUser
            firestore.collection("ListTravel")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        val id = document.id
                        val logo = document.get("logoTravel").toString()
                        val estimasiRute = document.get("estimasiRute").toString()
                        val totalJalan = document.get("totalJalan").toString()
                        val namaTravel = document.get("namaTravel").toString()
                        val rutePerjalanan = document.get("rutePerjalanan").toString()
                        val harga = document.get("harga").toString()
                        travelList.add(Travel(id, logo, estimasiRute, totalJalan, namaTravel, rutePerjalanan, harga))
                    }
                    if (travelList.size > 0) {
                        mFirstFragment.listTravel = travelList
                        list_of_travel.adapter = adapter
                        adapter.listTravel = travelList
                    }
                    else {
                        adapter.listTravel.clear()
                        list_of_travel?.adapter?.notifyDataSetChanged()
                        showSnackbarMessage("Tidak ada daftar travel saat ini")
                    }
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this@ListTravelActivity,
                        "Error adding document", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun showSnackbarMessage(message: String) {
        Snackbar.make(list_travel_container, message, Snackbar.LENGTH_SHORT).show()
    }

}