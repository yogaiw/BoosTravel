package com.stigma_mm1.boostravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_daftar_user.*

class daftar_user : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_user)

        btnDaftar.setOnClickListener {
            val namaU = edtNama.text.toString()
            val emailU = edtEmail.text.toString()
            val hpU = edtNoHp.text.toString()
            val pwdU = edtPassword.text.toString()

            Log.d("ActivityState", "Berhasil terdaftar")
            Toast.makeText(applicationContext, "Berhasil terdaftar", Toast.LENGTH_SHORT).show()
        }
    }
}