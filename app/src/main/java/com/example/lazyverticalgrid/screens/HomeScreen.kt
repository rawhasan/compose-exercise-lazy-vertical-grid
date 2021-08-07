package com.example.lazyverticalgrid.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.lazyverticalgrid.data.DestinationDataSource
import com.example.lazyverticalgrid.model.Destination

@ExperimentalFoundationApi
@Composable
fun HomeScreen(navController: NavHostController) {
    val destinations = DestinationDataSource().loadData()

    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 140.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(destinations) { destination ->
            Row(Modifier.padding(8.dp)) {
                ItemLayout(destination, navController)
            }
        }
    }
}

@Composable
fun ItemLayout(destination: Destination, navController: NavHostController) {
    //val destinationName = stringResource(destination.nameId)
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(MaterialTheme.colors.primaryVariant)
            .fillMaxWidth()
            .clickable {
                navController.navigate("details/${destination.nameId}")
            }
    ) {
        Image(
            painter = painterResource(destination.photoId),
            contentDescription = stringResource(destination.nameId),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Text(
            text = stringResource(destination.nameId),
            color = Color.White,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        )
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreenPreview() {
    //HomeScreen(navController)
}


