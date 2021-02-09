package com.stigma_mm1.boostravel.mitra_side

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.stigma_mm1.boostravel.R
import kotlinx.android.synthetic.main.activity_tambah_jurusan.*

class TambahJurusanActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private var kotaSpinnerArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_jurusan)

        firestore = Firebase.firestore

        kotaSpinnerArray = getKota()
    }

    private fun getKota(): ArrayList<String> {
        firestore.collection("Kota").get().addOnSuccessListener {
            var selection = 0
            for(document in it) {
                val name = document.get("nama").toString()
                kotaSpinnerArray.add(name)
                selection++
            }
            setKota(kotaSpinnerArray)
        }.addOnFailureListener {
            Toast.makeText(this, "Kesalahan",Toast.LENGTH_SHORT).show()
        }
        return kotaSpinnerArray
    }

    private fun setKota(paymentMethodSpinnerArray: ArrayList<String>) {
        var spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, paymentMethodSpinnerArray)
        tambah_dari.adapter = spinnerAdapter
        tambah_ke.adapter = spinnerAdapter
    }
}