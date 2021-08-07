package com.example.lazyverticalgrid.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazyverticalgrid.data.DestinationDataSource

@Composable
fun DetailsScreen(nameId: String) {
    val dataSource = DestinationDataSource().loadData()
    val destinationIndex = dataSource.indexOfFirst { it.nameId == nameId.toInt() }

    val destination = dataSource[destinationIndex]
    val destinationName = stringResource(destination.nameId)
    val destinationDesc = stringResource(destination.descriptionId)
    val destinationImage = painterResource(destination.photoId)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = destinationImage,
            contentDescription = destinationName,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = destinationName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Text(text = destinationDesc, lineHeight = 24.sp)
        }
    }
}