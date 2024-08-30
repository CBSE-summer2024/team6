package com.example.native_navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.size
import androidx.compose.ui.tooling.preview.Preview
import com.example.native_navigation.ui.theme.AndroidTheme

@Composable
fun SearchTextField(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    searchBoxColor: Color = MaterialTheme.colorScheme.onBackground,
    shouldRequestFocus: Boolean = true,
    searchPlaceholder: String = "Search by name"
) {
    val focusRequester = remember { FocusRequester() }

    if (shouldRequestFocus) {
        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }
    }

    BasicTextField(
        value = searchText,
        onValueChange = {
            onSearchTextChange(it)
        },
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.secondary),
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.secondary,
            fontSize = 20.sp
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = modifier
                    .background(
                        color = searchBoxColor,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (searchText.isEmpty()) {
                    Text(
                        text = searchPlaceholder,
                        color = Color.Gray,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal),
                        maxLines = 1
                    )
                } else {
                    Box(Modifier.weight(1f)) {
                        innerTextField()
                    }
                    IconButton(
                        onClick = {
                            onSearchTextChange("")
                        },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }
                }
            }
        },
        modifier = modifier
            .padding(10.dp)
            .focusRequester(focusRequester)
            .fillMaxWidth()
            .height(45.dp)

    )
}

@Preview
@Composable
fun SearchTextFieldPreview(){
    AndroidTheme {
        SearchTextField(
            searchText = "",
            onSearchTextChange = {}
        )
    }
}