package com.dica.bookcatalog.ui.screens.list


 import kotlin.text.firstOrNull import kotlin.text.isNotEmpty // String.isNotEmpty и List.isNotEmpty используются напрямую

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dica.bookcatalog.R
import com.dica.bookcatalog.data.datasource.BookDatasource
import com.dica.bookcatalog.data.model.Book
import com.dica.bookcatalog.ui.theme.BookCatalogTheme
import com.dica.bookcatalog.ui.widgets.BookItem
import com.dica.bookcatalog.ui.widgets.CategoryChip
import com.dica.bookcatalog.ui.widgets.SearchTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookListScreen(
    onBookClick: (Book) -> Unit,
    modifier: Modifier = Modifier,
    initialBooks: List<Book> = BookDatasource.getAllBooks(),
    initialCategories: List<String> = BookDatasource.getAllCategories(),
    initialSearchQuery: String = "",
    initialSelectedCategory: String? = null
) {
    val allBooks = remember { initialBooks }
    val allCategories = remember { initialCategories }

    var searchQuery by rememberSaveable(initialSearchQuery) { mutableStateOf(initialSearchQuery) }
    var selectedCategory by rememberSaveable(initialSelectedCategory) {
        mutableStateOf(initialSelectedCategory ?: allCategories.firstOrNull() ?: BookDatasource.DEFAULT_CATEGORY_NAME)
    }

    val filteredBooks = remember(searchQuery, selectedCategory, allBooks) {
        allBooks.filter { book ->
            val matchesCategory = selectedCategory == BookDatasource.DEFAULT_CATEGORY_NAME || book.category == selectedCategory
            val matchesSearchQuery = searchQuery.isBlank() ||
                    book.title.contains(searchQuery, ignoreCase = true) ||
                    book.author.contains(searchQuery, ignoreCase = true)
            matchesCategory && matchesSearchQuery
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.app_name_short)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            SearchTextField(
                searchQuery = searchQuery,
                onQueryChanged = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp) // Увеличим отступы для лучшего вида
            )

            CategoryFilterRow(
                categories = allCategories,
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it }
            )

            AnimatedVisibility(
                visible = filteredBooks.isNotEmpty(),
                enter = fadeIn(animationSpec = tween(300)),
                exit = fadeOut(animationSpec = tween(300))
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp), // Согласуем горизонтальные отступы
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(filteredBooks, key = { it.id }) { book ->
                        BookItem(
                            book = book,
                            onItemClick = onBookClick
                        )
                    }
                }
            }

            AnimatedVisibility(
                visible = filteredBooks.isEmpty(),
                enter = fadeIn(animationSpec = tween(300, delayMillis = 150)),
                exit = fadeOut(animationSpec = tween(150))
            ) {
                EmptyState(
                    modifier = Modifier.fillMaxSize(),
                    message = if (searchQuery.isNotBlank() || (selectedCategory != BookDatasource.DEFAULT_CATEGORY_NAME && allCategories.contains(selectedCategory))) {
                        stringResource(R.string.no_books_found_filter)
                    } else {
                        stringResource(R.string.no_books_available)
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryFilterRow(
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(bottom = 8.dp)) { // Добавим нижний отступ
        if (categories.isNotEmpty() && (categories.size > 1 || categories.first() != BookDatasource.DEFAULT_CATEGORY_NAME)) {
            Text(
                text = stringResource(R.string.categories_title),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp) // Увеличим вертикальный отступ
            )
        }
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                CategoryChip(
                    categoryName = category,
                    isSelected = category == selectedCategory,
                    onCategorySelected = { onCategorySelected(category) }
                )
            }
        }
    }
}

@Composable
fun EmptyState(message: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview(showBackground = true, name = "Book List - Light")
@Composable
fun BookListScreenPreviewLight() {
    BookCatalogTheme(darkTheme = false) {
        BookListScreen(onBookClick = {})
    }
}

@Preview(showBackground = true, name = "Book List - Dark")
@Composable
fun BookListScreenPreviewDark() {
    BookCatalogTheme(darkTheme = true) {
        BookListScreen(onBookClick = {})
    }
}