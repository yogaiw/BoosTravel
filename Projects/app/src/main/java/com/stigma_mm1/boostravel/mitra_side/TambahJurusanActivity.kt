package com.stigma_mm1.boostravel.mitra_side

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import com.stigma_mm1.boostravel.R
import kotlinx.android.synthetic.main.activity_tambah_jurusan.*

class TambahJurusanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_jurusan)

        val firestore = FirebaseFirestore.getInstance()
        val kotaRef = firestore.collection("Kota")
        var kota = ArrayList<String>()
        var adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, kota)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        kotaRef.get().addOnCompleteListener {
            if(it.isSuccessful) {
                for(document in it.result!!) {
                    var k = document.getString("nama")
                    kota.add(k.toString())
                    Log.d("TAG", k.toString())
                }
                adapter.notifyDataSetChanged()
                tambah_dari.adapter
                tambah_ke.adapter
            }
        }
    }
}