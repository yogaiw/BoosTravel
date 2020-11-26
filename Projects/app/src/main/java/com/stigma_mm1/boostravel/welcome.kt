package com.stigma_mm1.boostravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_welcome.*

class welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        btn_login.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        })

        btn_daftar.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, daftar::class.java)
            startActivity(intent)
        })
    }
}