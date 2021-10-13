package com.stigma_mm1.boostravel.user_side

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stigma_mm1.boostravel.R
import com.stigma_mm1.boostravel.fragments.ListPesananUser

class PesananActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MYDATA = "extra_mydata"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesanan)

        val mFragmentManager = supportFragmentManager
        val mFirstFragment = ListPesananUser()
        val fragment = mFragmentManager.findFragmentByTag(ListPesananUser::class.java.simpleName)
        if (fragment !is ListPesananUser) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + ListPesananUser::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.list_pesananUser_container, mFirstFragment, ListPesananUser::class.java.simpleName)
                .commit()
        }
    }
}