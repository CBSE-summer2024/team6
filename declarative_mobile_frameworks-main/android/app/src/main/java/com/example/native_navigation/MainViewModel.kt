package com.example.native_navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.native_navigation.model.CardUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {
    private val _itemsStateFlow = MutableStateFlow<List<CardUiModel>>(emptyList())
    val itemsStateFlow = _itemsStateFlow.asStateFlow()

    private val _searchQueryStateFlow = MutableStateFlow("")
    val searchQueryStateFlow = _searchQueryStateFlow.asStateFlow()

    @OptIn(FlowPreview::class)
    val searchResults = combine(
        itemsStateFlow,
        _searchQueryStateFlow.debounce {
            if (it.isBlank()) 0
            else 500L
        }
    ) { items, searchQuery ->
        val filteredAppointments = if (searchQuery.isBlank()) items
        else {
            items.filter {
                it.title.contains(searchQuery, ignoreCase = true)
            }
        }
        filteredAppointments
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    fun onSearchTextChange(searchText: String) {
        _searchQueryStateFlow.value = searchText
    }

    init {
        //mock data
        _itemsStateFlow.value = listOf(
            CardUiModel(
                title = "Dress",
                description = "Pink Dress",
                isFavorite = true,
                oldPrice = 60,
                currentPrice = 40,
                photo = "https://media.istockphoto.com/id/1440977634/photo/vertical-shot-of-the-beautiful-pink-dress-isolated-on-the-white-background.jpg?s=612x612&w=0&k=20&c=3lSPxjs-xh7PGeW2eGnPlawyw9gcJPlnc1QWnwnkNyI=",
                numOfStars = 5
            ),
            CardUiModel(
                title = "Jaket",
                description = "Jaket bomber pria terbaru",
                isFavorite = true,
                oldPrice = 21,
                currentPrice = 14,
                photo = "https://images.tokopedia.net/img/cache/500-square/VqbcmM/2023/1/20/55825998-7ab3-4a72-82cc-3406f260a171.jpg",
                numOfStars = 4
            ),
            CardUiModel(
                title = "Sneakers",
                description = "White Sneakers for Men",
                isFavorite = false,
                oldPrice = 80,
                currentPrice = 50,
                photo = "https://cdn.pixabay.com/photo/2016/11/19/18/06/feet-1840619_640.jpg",
                numOfStars = 4
            ),
            CardUiModel(
                title = "Watch",
                description = "Luxury Men's Watch",
                isFavorite = true,
                oldPrice = 250,
                currentPrice = 180,
                photo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnJeP50BQ1dkR0_D7a8n0AQyptM1hBooNwEg&s",
                numOfStars = 5
            ),
            CardUiModel(
                title = "Sunglasses",
                description = "Stylish Sunglasses",
                isFavorite = false,
                oldPrice = 120,
                currentPrice = 85,
                photo = "https://m.media-amazon.com/images/I/31NvXL-aMrL._AC_UY1100_.jpg",
                numOfStars = 4
            ),
            CardUiModel(
                title = "Handbag",
                description = "Designer Handbag",
                isFavorite = true,
                oldPrice = 320,
                currentPrice = 280,
                photo = "https://wwd.com/wp-content/uploads/2023/03/designer-handbag-lead-art.jpg?w=911&h=510&crop=1",
                numOfStars = 5
            )
        )


        _itemsStateFlow.value += (1..100).map {
            CardUiModel(
                title = "Dress$it",
                description = "Dress",
                isFavorite = it % 2 == 0,
                oldPrice = 21,
                currentPrice = 14,
                photo = "https://i.pinimg.com/474x/17/31/a2/1731a2e94e7608749f7e9a7526ad9173.jpg",
                numOfStars = it % 5 + 1
            )
        }
    }
}