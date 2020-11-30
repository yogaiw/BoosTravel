package com.stigma_mm1.boostravel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.stigma_mm1.boostravel.adapter.ItemListTravelView

class list_travel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_travel)

        val mFragmentManager = supportFragmentManager
        val mFirstFragment = ItemListTravelView()
        val fragment = mFragmentManager.findFragmentByTag(ItemListTravelView::class.java.simpleName)
        if (fragment !is ItemListTravelView) {
            Log.d("MyFlexibleFragment", "Fragment Name :" + ItemListTravelView::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.list_travel_container, mFirstFragment, ItemListTravelView::class.java.simpleName)
                .commit()
        }
    }
}