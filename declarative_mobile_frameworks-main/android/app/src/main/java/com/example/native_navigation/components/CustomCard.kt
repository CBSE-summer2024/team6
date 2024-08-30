package com.example.native_navigation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.native_navigation.model.CardUiModel
import com.example.native_navigation.ui.theme.AndroidTheme

@Composable
fun CustomCard(
    item: CardUiModel,
    backgroundColor: Color = MaterialTheme.colorScheme.onBackground
) {
    var isFavorite by rememberSaveable { mutableStateOf(item.isFavorite) }

    Card(
        modifier = Modifier.padding(5.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = backgroundColor,
        elevation = 5.dp
    ) {
        Box {
            Column {
                Image(
                    painter = rememberAsyncImagePainter(item.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp)
                        .background(Color.LightGray)
                )

                Column(
                    modifier = Modifier.padding(15.dp)
                ) {
                    StarRatingBar(
                        maxStars = 5,
                        rating = item.numOfStars.toFloat(),
                    )

                    Text(
                        text = item.description,
                        color = Color(0xff9B9B9B),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal
                    )

                    Text(
                        text = item.title,
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${item.oldPrice}$",
                            color = Color(0xff9B9B9B),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            textDecoration = TextDecoration.LineThrough
                        )

                        Spacer(modifier = Modifier.width(2.dp))

                        Text(
                            text = "${item.currentPrice}$",
                            color = Color(0xffDB3022),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            BoxWithConstraints {
                val maxWidth = maxWidth
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .offset(x = maxWidth.minus(36.dp), y = 110.dp)
                        .shadow(elevation = 2.dp, shape = CircleShape)
                        .background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp)
                            .clickable { isFavorite = !isFavorite },
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFavorite) Color(0xffDB3022) else Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun StarRatingBar(
    maxStars: Int = 5,
    rating: Float
) {
    val density = LocalDensity.current.density
    val starSize = (7f * density).dp
    val starSpacing = (0.5f * density).dp

    Row(
        modifier = Modifier.selectableGroup(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..maxStars) {
            val isSelected = i <= rating
            val icon = if (isSelected) Icons.Filled.Star else Icons.Default.Star
            val iconTintColor = if (isSelected) Color(0xFFFFBA49) else Color(0x20FFFFFF)
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTintColor,
                modifier = Modifier
                    .width(starSize)
                    .height(starSize)
            )

            if (i < maxStars) {
                Spacer(modifier = Modifier.width(starSpacing))
            }
        }
    }
}

@Preview
@Composable
fun CustomCardPreview() {
    AndroidTheme {
        CustomCard(
            CardUiModel(
                title = "Blouse",
                description = "Dorothy Perkins",
                isFavorite = false,
                oldPrice = 21,
                currentPrice = 14,
                photo = "https://i.pinimg.com/474x/17/31/a2/1731a2e94e7608749f7e9a7526ad9173.jpg",
                numOfStars = 4
            )
        )
    }
}