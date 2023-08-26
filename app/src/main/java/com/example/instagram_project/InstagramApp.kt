package com.example.instagram_project

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.instagram_project.destination.Destination
import com.example.instagram_project.destination.NavigationAppHost
import com.example.instagram_project.model.BottomNavItem

//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InstagramApp() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {

            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "Home",
                        route = Destination.HomeScreen.route,
                        icon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        name = "Notif",
                        route = Destination.NotificationScreen.route,
                        icon = Icons.Default.Notifications
                    ),

                    BottomNavItem(
                        name = "Reels",
                        route = Destination.ReelsScreen.route,
                        icon = Icons.Default.ThumbUp
                    ),

                    BottomNavItem(
                        name = "Search",
                        route = Destination.SearchScreen.route,
                        icon = Icons.Default.Search
                    ),

                    BottomNavItem(
                        name = "Profile",
                        route = Destination.ProfileScreen.route,
                        icon = Icons.Default.Person
                    ),

                    ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                },


            )
        }
    )
    {
        NavigationAppHost(navController)
    }
}


@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()

    NavigationBar(
        modifier = modifier.height(60.dp),
        containerColor = Color.White,
//        tonalElevation = 5.dp
//        windowInsets = NavigationBarDefaults.windowInsets
    )
    {

        items.forEach { item ->

            val selected = item.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = { onItemClick(item) },

                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Color.White.copy(alpha = 0.5f),
                    selectedTextColor = Color.Red,
                    selectedIconColor = Color.Red,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.White
                ),

                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {


                        if(item.route == Destination.ProfileScreen.route){
                            CircleProfileView()
                        }else{
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,
                                tint = if (selected) Color.Red else Color.Black
                            )
                        }
                        if (selected) {
                            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                        }
                    }
                }

            )
        }
    }
}

@Composable
fun CircleProfileView() {
    Image(
        painter = painterResource(id = R.drawable.image3),
        contentDescription = "", modifier = Modifier.size(24.dp).clip(CircleShape)
    )
}

@Composable
@Preview
fun InstagramAppPreview(){
    InstagramApp()
}