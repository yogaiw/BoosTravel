package com.stigma_mm1.boostravel.mitra_side

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.stigma_mm1.boostravel.R
import com.stigma_mm1.boostravel.user_side.CariJurusanActivity
import kotlinx.android.synthetic.main.activity_mitra_home.*

class DashboardMitraActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mitra_home)

        btn_tambah_jurusan.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_tambah_jurusan -> {
                val intent = Intent(this, TambahJurusanActivity::class.java)
                startActivity(intent)
            }
        }
    }
}