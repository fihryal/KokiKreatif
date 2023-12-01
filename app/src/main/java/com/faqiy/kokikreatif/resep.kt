package com.faqiy.kokikreatif

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class resep(
    val nama: String,
    val bahan: String,
    val resep: String,
    val kesimpulan: String,
    val img: Int
):Parcelable
