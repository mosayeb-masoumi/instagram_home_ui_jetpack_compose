package com.example.instagram_project.destination

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagram_project.screens.HomeScreen
import com.example.instagram_project.screens.NotificationScreen
import com.example.instagram_project.screens.ProfileScreen
import com.example.instagram_project.screens.ReelsScreen
import com.example.instagram_project.screens.SearchScreen

sealed class Destination(val route: String) {

    object HomeScreen : Destination("HomeScreen")
    object NotificationScreen : Destination("NotificationScreen")
    object ProfileScreen : Destination("ProfileScreen")
    object ReelsScreen : Destination("ReelsScreen")
    object SearchScreen : Destination("SearchScreen")
}


@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destination.HomeScreen.route
    ) {

        composable(Destination.HomeScreen.route) { HomeScreen(navController) }
        composable(Destination.NotificationScreen.route) { NotificationScreen(navController) }
        composable(Destination.ProfileScreen.route) { ProfileScreen(navController) }
        composable(Destination.ReelsScreen.route) { ReelsScreen(navController) }
        composable(Destination.SearchScreen.route) { SearchScreen(navController) }

    }
}
