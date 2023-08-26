package com.example.instagram_project.components

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.example.instagram_project.R
import com.example.instagram_project.model.User

@Composable
fun LikeSection(likedBy: List<User>) {

    when (likedBy.size) {
        1 -> {
            Text(
                text = "liked by ${likedBy[0].userName}",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
        }
        2 -> {
            Text(
                text = "${likedBy.size} likes",
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                modifier = Modifier.padding(horizontal = 5.dp)
            )
        }
        else -> {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(10.dp)
            ) {
                PostLikedViewByProfile(likedBy)
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "liked by ${likedBy[0].userName} and ${likedBy.size - 1} others",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
            }

        }
    }
}

@Composable
fun PostLikedViewByProfile(likedBy: List<User>) {

    LazyRow(horizontalArrangement = Arrangement.spacedBy((-5).dp)) {
        items(likedBy.take(4)) { User ->
            Image(
                painter = painterResource(id = User.profile),
                contentDescription = "myImage",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
                    .border(
                        shape = CircleShape,
                        width = 2.dp,
                        color = Color.White
                    )
            )
        }
    }
}
