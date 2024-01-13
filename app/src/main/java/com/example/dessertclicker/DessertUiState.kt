package com.example.dessertclicker

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.model.Dessert

data class DessertUiState(
    val revenue: Int = 0,
    val sold: Int = 0,
    val index: Int = 0,
    val price: Int = Datasource.dessertList[index].price,
    @DrawableRes val imageId: Int = Datasource.dessertList[index].imageId,
    val desserts: List<Dessert> = Datasource.dessertList
)