package com.example.instagram_project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import com.example.instagram_project.R
import com.example.instagram_project.model.Story

@Composable
fun StoryItem(story: Story) {

    Column(
        modifier =Modifier.padding(all = 2.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = story.image),
            contentDescription = "myImage",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(
                    shape = CircleShape,
                    width = 2.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color("#FFDE0046".toColorInt()),
                            Color("#FF47A34B".toColorInt()),
                        )
                    )
                )
            )

        Text(text = story.userName)
    }
}

@Preview
@Composable
fun StoryItemPreview() {
    StoryItem(story = Story("hassan", "profileImage", R.drawable.ic_launcher_background))
}