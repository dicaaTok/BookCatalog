package com.dica.bookcatalog.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    val id: String,
    val title: String,
    val author: String,
    val description: String,
    val category: String,
    val coverImageUrl: String? = null,
    val yearPublished: Int? = null,
    val pageCount: Int? = null,
    val rating: Float? = null
) : Parcelable