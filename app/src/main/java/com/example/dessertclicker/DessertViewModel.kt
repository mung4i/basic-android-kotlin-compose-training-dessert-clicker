package com.example.dessertclicker

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun determineDessertToShow() {
        for (dessert in _uiState.value.desserts) {
            if (_uiState.value.sold >= dessert.startProductionAmount) {
                updateCurrentDessert(dessert)
            } else {
                break
            }
        }
    }

    private fun updateCurrentDessert(dessert: Dessert) {
        _uiState.update {
            it.copy(
                price = dessert.price,
                imageId = dessert.imageId
            )
        }
    }

    fun updateRevenue() {
        _uiState.update {
            it.copy(
                revenue = _uiState.value.revenue + _uiState.value.price,
                sold = _uiState.value.sold + 1
            )
        }
    }
}