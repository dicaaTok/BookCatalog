import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dica.bookcatalog.data.model.Book
import com.dica.bookcatalog.ui.screens.detail.BookDetailScreen
import com.dica.bookcatalog.ui.screens.list.BookListScreen
import com.dica.bookcatalog.ui.theme.BookCatalogTheme

@Preview(showBackground = true, name = "BookCatalogApp - Showing List")
@Composable
fun BookCatalogAppShowingListPreview() {
    BookCatalogTheme {
        BookListScreen(onBookClick = {})
    }
}

@Preview(showBackground = true, name = "BookCatalogApp - Showing Detail")
@Composable
fun BookCatalogAppShowingDetailPreview() {
    BookCatalogTheme {
        val sampleBookForPreview = Book(
            id = "preview-detail-app-001",
            title = "Тестовая Книга для Детального Превью",
            author = "Автор Превью",
            description = "Это очень интересное описание книги, которое мы используем специально для того, чтобы протестировать, как выглядит экран детальной информации в режиме превью. Оно может быть достаточно длинным, чтобы проверить перенос строк и общее отображение текста.",
            category = "Превью Категория",
            coverImageUrl = null,
            yearPublished = 2024,
            pageCount = 321,
            rating = 4.5f
        )

        BookDetailScreen(book = sampleBookForPreview, onNavigateBack = {})
    }
}