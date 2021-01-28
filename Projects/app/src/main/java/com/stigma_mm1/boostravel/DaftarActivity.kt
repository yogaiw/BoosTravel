package com.stigma_mm1.boostravel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stigma_mm1.boostravel.mitra_side.DaftarMitraActivity
import com.stigma_mm1.boostravel.user_side.DaftarUserActivity
import kotlinx.android.synthetic.main.activity_daftar.*

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)

        btnDaftarUser.setOnClickListener {
            val daftarUser = Intent(this, DaftarUserActivity::class.java)
            startActivity(daftarUser)
        }

        btnDaftarMitra.setOnClickListener {
            val daftarMitra = Intent(this, DaftarMitraActivity::class.java)
            startActivity(daftarMitra)
        }

        loginBtn.setOnClickListener {
            val goToLogin = Intent(this, LoginActivity::class.java)
            startActivity(goToLogin)
        }
    }

}