package com.example.native_navigation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.native_navigation.R
import com.example.native_navigation.components.CustomCard
import com.example.native_navigation.components.SearchTextField
import com.example.native_navigation.model.CardUiModel
import com.example.native_navigation.ui.theme.AndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onBackClicked: () -> Unit = { }
) {
    val items = (1..100).map {
        CardUiModel(
            title = "Cap",
            description = "Dorothy Perkins",
            isFavorite = it % 2 == 0,
            oldPrice = 21,
            currentPrice = 14,
            photo = "https://i.pinimg.com/474x/17/31/a2/1731a2e94e7608749f7e9a7526ad9173.jpg",
            numOfStars = it % 5 + 1
        )
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.onBackground,
        topBar = {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .shadow(2.dp)
            ){
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .weight(.1f)
                            .padding(start = 10.dp)
                            .size(30.dp)
                            .clickable { onBackClicked.invoke() },
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.Black
                    )

                    SearchTextField(
                        modifier = Modifier.weight(.8f),
                        searchText = "",
                        onSearchTextChange = {}
                    )

                    Icon(
                        modifier = Modifier
                            .weight(.1f)
                            .padding(end = 10.dp)
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.message_question),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ){
                    Category("Recommended")
                    Category("Price")
                    Category("Category")
                }
            }
        }
    ) { padding ->
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(5.dp),
            columns = GridCells.Fixed(2),
        ) {
            items(items) {
                CustomCard(
                    item = it
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Category(text:String){
    InputChip(
        onClick = { },
        selected = false,
        label = { Text(text = text, color = Color(0xff262626)) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "Localized description",
                modifier = Modifier.size(InputChipDefaults.AvatarSize),
                tint = Color(0xff292D32)
            )
        },
        colors =  InputChipDefaults.inputChipColors(
            labelColor = Color.Gray
        )
    )
}

@Preview
@Composable
fun SearchScreenPreview() {
    AndroidTheme {
        SearchScreen()
    }
}