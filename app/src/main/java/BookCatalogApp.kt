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
        val sampleBookForPreview = Book(  )

        BookDetailScreen(book = sampleBookForPreview, onNavigateBack = {})
    }
}