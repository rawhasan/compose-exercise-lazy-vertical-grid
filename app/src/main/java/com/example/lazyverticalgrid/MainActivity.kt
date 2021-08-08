package com.example.lazyverticalgrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
fun LazyVerticalGridActivityScreen() {
    Column {
        val navController = rememberNavController()

        TopAppBar(title = { Text("Lazy Vertical Grid") })

        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomeScreen(navController) }
            composable("details/{listId}") { backStackEntry ->
                backStackEntry.arguments?.getString("listId")?.let { DetailsScreen(it, navController) }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyVerticalGridActivityScreen()
}