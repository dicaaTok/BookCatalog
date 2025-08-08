package com.dica.bookcatalog.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class User(
    val firstName: String,
    val lastName: String,
    val age: Int
) : Parcelable