package com.stigma_mm1.boostravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_daftar.*

class daftar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        btnDaftarUser.setOnClickListener {
            val daftarUser = Intent(this, daftar_user::class.java)
            startActivity(daftarUser)
        }

        btnDaftarMitra.setOnClickListener {
            val daftarMitra = Intent(this, daftar_mitra::class.java)
            startActivity(daftarMitra)
        }

        loginBtn.setOnClickListener {
            val goToLogin = Intent(this, login::class.java)
            startActivity(goToLogin)
        }
    }

}