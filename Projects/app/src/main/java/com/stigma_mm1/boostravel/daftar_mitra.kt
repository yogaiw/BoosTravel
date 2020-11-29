package com.stigma_mm1.boostravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_daftar_mitra.*

class daftar_mitra : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_mitra)

        btnDaftar.setOnClickListener {
            val namaM = edtNama.text.toString()
            val emailM = edtEmail.text.toString()
            val hpM = edtNoHp.text.toString()
            val alamatM = edtAlamat.text.toString()
            val pwdM = edtPassword.text.toString()

            Log.d("ActivityState", "Berhasil terdaftar")
            Toast.makeText(applicationContext, "Berhasil terdaftar", Toast.LENGTH_SHORT).show()


        }
    }
}