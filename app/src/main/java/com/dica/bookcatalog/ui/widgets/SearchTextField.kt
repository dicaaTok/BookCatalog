package com.dica.bookcatalog.ui.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dica.bookcatalog.ui.theme.BookCatalogTheme

@Composable
fun SearchTextField(
    searchQuery: String,
    onQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        value = searchQuery,
        onValueChange = onQueryChanged,
        modifier = modifier
            .fillMaxWidth(),
        //.padding(horizontal = 16.dp, vertical = 8.dp),
        placeholder = { Text(stringResource(R.string.search_placeholder)) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.cd_search_icon)
            )
        },
        trailingIcon = {
            if (searchQuery.isNotEmpty()) {
                IconButton(onClick = {
                    onQueryChanged("")
                }) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = stringResource(R.string.cd_clear_search)
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                keyboardController?.hide()
                focusManager.clearFocus()
            }
        ),
        singleLine = true,
        shape = MaterialTheme.shapes.extraLarge
    )
}

@Preview(showBackground = true, name = "SearchTextField Empty Light")
@Composable
fun SearchTextFieldPreviewEmptyLight() {
    BookCatalogTheme(darkTheme = false) {
        Surface(modifier = Modifier.padding(16.dp)) {
            SearchTextField(searchQuery = "", onQueryChanged = {})
        }
    }
}

@Preview(showBackground = true, name = "SearchTextField With Text Dark")
@Composable
fun SearchTextFieldPreviewWithTextDark() {
    BookCatalogTheme(darkTheme = true) {
        Surface(modifier = Modifier.padding(16.dp)) {
            SearchTextField(searchQuery = "Kotlin", onQueryChanged = {})
        }
    }
}