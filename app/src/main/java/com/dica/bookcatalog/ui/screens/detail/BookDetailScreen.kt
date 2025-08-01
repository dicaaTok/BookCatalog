package com.dica.bookcatalog.ui.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.error
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dica.bookcatalog.R
import com.dica.bookcatalog.data.model.Book
import com.dica.bookcatalog.ui.theme.BookCatalogTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookDetailScreen(
    book: Book,
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = book.title,
                        maxLines = 1,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.cd_navigate_back)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(book.coverImageUrl)
                    .crossfade(true)
                    .placeholder(R.drawable.ic_placeholder_book)
                    .error(R.drawable.ic_placeholder_book)
                    .build(),
                contentDescription = stringResource(R.string.cd_book_cover, book.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 200.dp, max = 300.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = book.title,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.detail_author_label, book.author),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = stringResource(R.string.detail_category_label, book.category),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            book.yearPublished?.let { year ->
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.detail_year_published_label, year.toString()),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            book.pageCount?.let { pages ->
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.detail_page_count_label, pages.toString()),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            book.rating?.let { rating ->
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(R.string.detail_rating_label, String.format("%.1f", rating)),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.detail_description_title),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = book.description,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

private val sampleBookForPreview = Book(
    id = "preview-101",
    title = "Очень Длинное Название Книги, Которое Может Не Поместиться в Одну Строку",
    author = "Известный Автор",
    description = "Это очень подробное и длинное описание книги, которое занимает несколько абзацев. Оно рассказывает о сюжете, главных героях, историческом контексте и многом другом. Цель этого описания - дать полное представление о произведении и заинтересовать читателя. \n\nВторой абзац описания, продолжающий мысль и добавляющий еще больше деталей о книге. Возможно, здесь будут цитаты или отзывы критиков.",
    category = "Фантастика и Приключения",
    coverImageUrl = null,
    yearPublished = 2023,
    pageCount = 345,
    rating = 4.7f
)

private val sampleBookWithCoverForPreview = Book(
    id = "preview-102",
    title = "Книга с Обложкой для Превью",
    author = "Другой Автор",
    description = "Краткое описание книги с обложкой. Эта книга используется для демонстрации того, как выглядит экран с реальным изображением обложки.",
    category = "Научная Фантастика",
    coverImageUrl = "https://example.com/sample_cover.jpg",
    yearPublished = 2022,
    pageCount = 280,
    rating = 4.2f
)

@Preview(showBackground = true, name = "Book Detail - Light Theme (No Cover)")
@Composable
fun BookDetailScreenPreviewLightNoCover() {
    BookCatalogTheme(darkTheme = false) {
        BookDetailScreen(book = sampleBookForPreview, onNavigateBack = {})
    }
}

@Preview(showBackground = true, name = "Book Detail - Dark Theme (No Cover)")
@Composable
fun BookDetailScreenPreviewDarkNoCover() {
    BookCatalogTheme(darkTheme = true) {
        BookDetailScreen(book = sampleBookForPreview, onNavigateBack = {})
    }
}

@Preview(showBackground = true, name = "Book Detail - Light Theme (With Cover)")
@Composable
fun BookDetailScreenPreviewLightWithCover() {
    BookCatalogTheme(darkTheme = false) {
        BookDetailScreen(book = sampleBookWithCoverForPreview, onNavigateBack = {})
    }
}

@Preview(showBackground = true, name = "Book Detail - Dark Theme (With Cover)")
@Composable
fun BookDetailScreenPreviewDarkWithCover() {
    BookCatalogTheme(darkTheme = true) {
        BookDetailScreen(book = sampleBookWithCoverForPreview, onNavigateBack = {})
    }
}