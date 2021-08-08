package com.example.lazyverticalgrid.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lazyverticalgrid.data.DestinationDataSource

@Composable
fun DetailsScreen(index: String, navController: NavController) {
    val dataSource = DestinationDataSource().loadData()

    val destination = dataSource[index.toInt()]
    val destinationName = stringResource(destination.nameId)
    val destinationDesc = stringResource(destination.descriptionId)
    val destinationImage = painterResource(destination.photoId)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
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
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(
                    onClick = { navController.navigate("home") },
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Image(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.primaryVariant),
                        modifier = Modifier.size(20.dp)
                    )
                    Text("Back to Destinations", modifier = Modifier.padding(start = 16.dp))
                }
            }
        }
    }
}