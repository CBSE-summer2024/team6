package com.example.native_navigation.model

data class CardUiModel(
    val id: Int = 0,
    val title: String = "Cap",
    val photo: String = "",
    val isFavorite: Boolean,
    val numOfStars: Int,
    val description: String,
    val oldPrice: Int,
    val currentPrice: Int
)
