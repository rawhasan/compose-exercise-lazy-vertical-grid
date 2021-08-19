package com.example.lazyverticalgrid.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lazyverticalgrid.DestinationViewModel
import com.example.lazyverticalgrid.data.DestinationDataSource

@Composable
fun DetailsScreen(
    index: String,
    navController: NavController,
    destinationViewModel: DestinationViewModel
) {
    val dataSource = DestinationDataSource().loadData()

    val destination = dataSource[index.toInt()]
    val destinationName = stringResource(destination.nameId)
    val destinationDesc = stringResource(destination.descriptionId)
    val destinationImage = painterResource(destination.photoId)

    LaunchedEffect(Unit) {
        destinationViewModel.setTitle(destinationName)
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()) // scrollable column
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
                    onClick = {
                        navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                    },
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Text("Back to Destinations")
                }
            }
        }
    }
}
