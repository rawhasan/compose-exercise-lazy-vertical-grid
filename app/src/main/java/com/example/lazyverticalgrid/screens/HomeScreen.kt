package com.example.lazyverticalgrid.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    val numbers = (1..21).toList()

    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 140.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(numbers) { number ->
            Row(Modifier.padding(8.dp)) {
                ItemLayout(number)
            }
        }
    }
}

@Composable
fun ItemLayout(number: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(MaterialTheme.colors.primaryVariant)
            .padding(horizontal = 24.dp, vertical = 32.dp)
            .fillMaxWidth()
    ) {
        Text(text = number.toString(), color = Color.White, fontSize = 20.sp)
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


