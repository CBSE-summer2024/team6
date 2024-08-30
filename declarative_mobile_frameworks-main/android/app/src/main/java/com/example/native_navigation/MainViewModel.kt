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
    init{
        _itemsStateFlow.value = (1..100).map {
            CardUiModel(
                title = "Cap$it",
                description = "Dorothy Perkins",
                isFavorite = it % 2 == 0,
                oldPrice = 21,
                currentPrice = 14,
                photo = "https://i.pinimg.com/474x/17/31/a2/1731a2e94e7608749f7e9a7526ad9173.jpg",
                numOfStars = it % 5 + 1
            )
        }
    }
}