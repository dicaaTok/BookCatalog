package com.dica.bookcatalog.ui.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dica.bookcatalog.data.model.Book
import com.dica.bookcatalog.ui.theme.BookCatalogTheme

@Composable
fun BookItem(
    book: Book,
    onItemClick: (Book) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            //.padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable { onItemClick(book) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = book.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = book.author,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = book.category,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview(showBackground = true, name = "BookItem Light")
@Composable
fun BookItemPreviewLight() {
    val sampleBook = Book(
        id = "1",
        title = "Очень длинное название книги, которое должно красиво обрезаться",
        author = "Талантливый Автор с Очень Длинным Именем",
        description = "Описание...",
        category = "Интересная Категория",
        coverImageUrl = null
    )
    BookCatalogTheme(darkTheme = false) {
        Box(modifier = Modifier.padding(8.dp)) {
            BookItem(book = sampleBook, onItemClick = {})
        }
    }
}

@Preview(showBackground = true, name = "BookItem Dark")
@Composable
fun BookItemPreviewDark() {
    val sampleBook = Book(
        id = "1",
        title = "Короткое название",
        author = "Автор",
        description = "Описание...",
        category = "Категория",
        coverImageUrl = null
    )
    BookCatalogTheme(darkTheme = true) {
        Box(modifier = Modifier.padding(8.dp)) {
            BookItem(book = sampleBook, onItemClick = {})
        }
    }
}