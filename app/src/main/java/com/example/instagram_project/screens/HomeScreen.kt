package com.example.instagram_project.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.instagram_project.components.PostItem
import com.example.instagram_project.components.StoryItem
import com.example.instagram_project.model.GetPosts
import com.example.instagram_project.model.Post
import com.example.instagram_project.model.Story
import com.example.instagram_project.model.StoryList


@Composable
fun HomeScreen(navController: NavHostController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 60.dp) // to prevent the last post be coverd by bottombar(60 is the height of bottombar too.
    ) {

        AppToolBar()
        StoriesSection(storyList = StoryList.list)
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .height(1.dp)
        )
        PostSection(GetPosts.posts)

    }
}

@Composable
fun AppToolBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(all = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Instagram", fontStyle = FontStyle.Italic, fontSize = 20.sp
            )

            Icon(
                modifier = Modifier.clickable {},
                imageVector = Icons.Default.Add, contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                modifier = Modifier.clickable {},
                imageVector = Icons.Default.Favorite, tint = Color.Red, contentDescription = ""
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                modifier = Modifier.clickable {},
                imageVector = Icons.Default.Email, tint = Color.Red, contentDescription = ""
            )

        }
    }
}


@Composable
fun StoriesSection(storyList: List<Story>) {
    LazyRow(modifier = Modifier.padding(start = 10.dp, end = 2.dp)) {
        items(storyList) { story ->
            StoryItem(story)
        }
    }
}


@Composable
fun PostSection(postList: List<Post>) {

    LazyColumn {
        items(postList) { post ->
            PostItem(post)
        }
    }
}

@Composable
@Preview
fun InstagramAppPreview() {
    val context = LocalContext.current
    HomeScreen(navController = NavHostController(context))
}



