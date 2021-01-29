package com.stigma_mm1.boostravel.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Travel (
    var idTravel: String,
    var logoTravel: String,
    var estimasiRute: String,
    var totalJalan: String,
    var namaTravel: String,
    var rutePerjalanan: String
)
: Parcelable