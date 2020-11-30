package com.stigma_mm1.boostravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stigma_mm1.boostravel.adapter.ListMitraRiwayatPesanan

class mitra_riwayat_pesanan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mitra_riwayat_pesanan)

        val mFragmentManager = supportFragmentManager
        val mFirstFragment = ListMitraRiwayatPesanan()
        val fragment = mFragmentManager.findFragmentByTag(ListMitraRiwayatPesanan::class.java.simpleName)
        if (fragment !is ListMitraRiwayatPesanan) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + ListMitraRiwayatPesanan::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.list_mitra_riwayat_pesanan_container, mFirstFragment, ListMitraRiwayatPesanan::class.java.simpleName)
                .commit()
        }
    }
}