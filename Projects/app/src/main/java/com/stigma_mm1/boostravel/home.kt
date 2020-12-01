package com.stigma_mm1.boostravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnPengumuman1.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }

        btnPengumuman2.setOnClickListener {
            startActivity(Intent(this, pengumuman::class.java))

        }

        btn_pesanan_anda.setOnClickListener {
            startActivity(Intent(this, pesanan::class.java))
        }

        btn_travel.setOnClickListener {
            startActivity(Intent(this, list_travel::class.java))
        }

        iv_inspirasi_liburan.setOnClickListener {
            startActivity(Intent(this, inspirasi_liburan::class.java))
        }
    }
}