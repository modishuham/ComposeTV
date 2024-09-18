package com.example.composetv

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Surface
import com.example.composetv.screens.DetailScreen
import com.example.composetv.screens.DetailScreenRoute
import com.example.composetv.screens.HomeScreen
import com.example.composetv.screens.HomeScreenRoute
import com.example.composetv.ui.theme.ComposeTVTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTVTheme {
                val navHostController = rememberNavController()
                NavGraph(navController = navHostController)
            }
        }
    }
}

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = HomeScreenRoute) {
        composable<HomeScreenRoute> {
            HomeScreen(navController = navController)
        }
        composable<DetailScreenRoute> { navBackStackEntry ->
            val arguments = navBackStackEntry.toRoute<DetailScreenRoute>()
            DetailScreen(
                navController = navController,
                name = arguments.name,
                image = arguments.image
            )
        }
    }
}