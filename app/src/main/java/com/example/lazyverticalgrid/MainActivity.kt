package com.example.lazyverticalgrid

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lazyverticalgrid.screens.DetailsScreen
import com.example.lazyverticalgrid.screens.HomeScreen

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalGridActivityScreen()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun LazyVerticalGridActivityScreen(destinationViewModel: DestinationViewModel = viewModel()) {
    val navController = rememberNavController()
    var canPop by remember { mutableStateOf(false) }

    Log.d("ActivityScreen_title", destinationViewModel.title.value)

    navController.addOnDestinationChangedListener { controller, _, _ ->
        canPop = controller.previousBackStackEntry != null
    }

    val navigationIcon: (@Composable () -> Unit)? =
        if (canPop) {
            {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        } else {
            null
        }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(destinationViewModel.title.value) }, navigationIcon = navigationIcon)
        },
        content = {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomeScreen(navController, destinationViewModel) }
                composable("details/{listId}") { backStackEntry ->
                    backStackEntry.arguments?.getString("listId")?.let { DetailsScreen(it, navController, destinationViewModel) }
                }
            }
        }
    )
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyVerticalGridActivityScreen()
}