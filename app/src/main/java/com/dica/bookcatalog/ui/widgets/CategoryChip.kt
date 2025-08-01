package com.dica.bookcatalog.ui.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dica.bookcatalog.ui.theme.BookCatalogTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryChip(
    categoryName: String,
    isSelected: Boolean,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    FilterChip(
        selected = isSelected,
        onClick = { onCategorySelected(categoryName) },
        label = { Text(categoryName) },
        modifier = modifier,
        leadingIcon = if (isSelected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Выбрано",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
            selectedLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        elevation = if (isSelected) FilterChipDefaults.filterChipElevation(elevation = 2.dp) else FilterChipDefaults.filterChipElevation(elevation = 0.dp),
        border = if (isSelected) {
            null
        } else {
            FilterChipDefaults.filterChipBorder(
                borderColor = MaterialTheme.colorScheme.outline,
                borderWidth = 1.dp,
                selectedBorderWidth = 1.dp
            )
        }
    )
}

@Preview(showBackground = true, name = "CategoryChip Selected Light")
@Composable
fun CategoryChipSelectedPreviewLight() {
    BookCatalogTheme(darkTheme = false) {
        Surface(modifier = Modifier.padding(8.dp)) {
            CategoryChip(
                categoryName = "Фантастика",
                isSelected = true,
                onCategorySelected = {}
            )
        }
    }
}

@Preview(showBackground = true, name = "CategoryChip Unselected Dark")
@Composable
fun CategoryChipUnselectedPreviewDark() {
    BookCatalogTheme(darkTheme = true) {
        Surface(modifier = Modifier.padding(8.dp)) {
            CategoryChip(
                categoryName = "Детектив",
                isSelected = false,
                onCategorySelected = {}
            )
        }
    }
}

@Preview(showBackground = true, name = "CategoryChip Long Name Light")
@Composable
fun CategoryChipLongNamePreviewLight() {
    BookCatalogTheme(darkTheme = false) {
        Surface(modifier = Modifier.padding(8.dp)) {
            CategoryChip(
                categoryName = "Научно-популярная литература",
                isSelected = false,
                onCategorySelected = {}
            )
        }
    }
}