package com.dica.bookcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dica.bookcatalog.data.model.Book
import com.dica.bookcatalog.navigation.Screen
import com.dica.bookcatalog.ui.screens.detail.BookDetailScreen
import com.dica.bookcatalog.ui.screens.list.BookListScreen
import com.dica.bookcatalog.ui.theme.BookCatalogTheme
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookCatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BookCatalogApp()
                }
            }
        }
    }
}

@Composable
fun BookCatalogApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.BookList) }

    when (val screen = currentScreen) {
        is Screen.BookList -> {
            BookListScreen(
                onBookClick = { book ->
                    currentScreen = Screen.BookDetail(book)
                }
            )
        }

        is Screen.BookDetail -> {
            BookDetailScreen(
                book = screen.book,
                onNavigateBack = {
                    currentScreen = Screen.BookList
                }
            )
            BackHandler(enabled = true) {
                currentScreen = Screen.BookList
            }
        }
    }
}

@Preview(showBackground = true, name = "BookCatalogApp - List View")
@Composable
fun BookCatalogAppListPreview() {
    BookCatalogTheme {
        var currentScreen by remember { mutableStateOf<Screen>(Screen.BookList) }
        when (val screen = currentScreen) {
            is Screen.BookList -> BookListScreen(onBookClick = { currentScreen = Screen.BookDetail(it) })
            is Screen.BookDetail -> {
                val dummyBook = Book("0", "Dummy", "Dummy", "Dummy", "Dummy")
                BookDetailScreen(book = screen.book, onNavigateBack = { currentScreen = Screen.BookList })
            }
        }
    }
}

@Preview(showBackground = true, name = "BookCatalogApp - Detail View")
@Composable
fun BookCatalogAppDetailPreview() {
    BookCatalogTheme {
        val sampleBookForPreview = Book(
            id = "preview-app-1",
            title = "Книга для Превью в App",
            author = "Автор из App Preview",
            description = "Описание для превью детального экрана в BookCatalogApp.",
            category = "Превью Категория App",
            coverImageUrl = null
        )
        var currentScreen by remember { mutableStateOf<Screen>(Screen.BookDetail(sampleBookForPreview)) }
        when (val screen = currentScreen) {
            is Screen.BookList -> BookListScreen(onBookClick = { currentScreen = Screen.BookDetail(it) })
            is Screen.BookDetail -> BookDetailScreen(book = screen.book, onNavigateBack = { currentScreen = Screen.BookList })
        }
    }
}