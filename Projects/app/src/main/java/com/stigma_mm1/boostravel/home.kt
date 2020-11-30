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
    }
}