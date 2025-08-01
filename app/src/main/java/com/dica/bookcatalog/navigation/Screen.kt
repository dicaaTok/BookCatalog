package com.dica.bookcatalog.navigation

import com.dica.bookcatalog.data.model.Book

sealed class Screen {
    object BookList : Screen()
    data class BookDetail(val book: Book) : Screen()
}