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
import androidx.compose.runtime.livedata.observeAsState
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
    val title: String by destinationViewModel.title.observeAsState("")

    Log.d("MainActivity_title", title ?: "__")

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
            TopAppBar(title = { Text(title) }, navigationIcon = navigationIcon)
        },
        content = {
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomeScreen(navController) }
                composable("details/{listId}") { backStackEntry ->
                    backStackEntry.arguments?.getString("listId")?.let { DetailsScreen(it, navController) }
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