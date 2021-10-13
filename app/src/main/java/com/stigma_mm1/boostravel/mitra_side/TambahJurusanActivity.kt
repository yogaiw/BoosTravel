package com.stigma_mm1.boostravel.mitra_side

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.stigma_mm1.boostravel.ListTravelActivity
import com.stigma_mm1.boostravel.R
import kotlinx.android.synthetic.main.activity_tambah_jurusan.*
import java.util.logging.Logger.global

class TambahJurusanActivity : AppCompatActivity() {

    private lateinit var firestore: FirebaseFirestore
    private lateinit var auth: FirebaseAuth
    private var kotaSpinnerArray = ArrayList<String>()
    private var dari: String = "0"
    private var tujuan: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_jurusan)

        firestore = Firebase.firestore
        auth = Firebase.auth

        kotaSpinnerArray = getKota()

        val tambahJurusan = firestore.collection("ListTravel").document()

        btn_tambah.setOnClickListener {
            val userDocRef = firestore.collection("Users").document(auth.uid!!)
            val destinasi = tambah_dari.selectedItem.toString() + " - " + tambah_ke.selectedItem.toString()
            val harga = "Rp." + edtHarga.text.toString()
            println("for delay")
            firestore.runTransaction {
                val snapshot = it.get(userDocRef)
                val mNamaTravel = snapshot.getString("nama")
                it.update(tambahJurusan,"namaTravel", mNamaTravel)
                null
            }
            println("for delay")
            val tambah = hashMapOf(
                    "rutePerjalanan" to destinasi,
                    "harga" to harga,
                    "uid" to auth.uid!!,
            )
            println("for delay")
            tambahJurusan.set(tambah).addOnSuccessListener {
                Toast.makeText(this, "Jurusan Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
            }

            startActivity(Intent(this, DashboardMitraActivity::class.java))
            finish()
        }
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

        tambah_dari.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                dari = position.toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        tambah_ke.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                tujuan = position.toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}