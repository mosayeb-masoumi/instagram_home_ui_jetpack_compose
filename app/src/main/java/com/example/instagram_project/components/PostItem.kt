package com.example.instagram_project.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram_project.R
import com.example.instagram_project.model.Post
import com.example.instagram_project.model.User

@Composable
fun PostItem(post: Post) {

    Column(modifier = Modifier
        .fillMaxWidth()) {

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = post.profile),
                contentDescription = "profile",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(30.dp)
                    .clip(shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = post.userName,
                Modifier.weight(1f),
                fontSize = 12.sp,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold

            )
            IconButton(onClick = {

            }) {
                Icon(Icons.Default.MoreVert, contentDescription = "")
            }
        }

        PostCarousel(post.postImageList)

        LikeSection(post.likedBy)

        BuildDescription(post)

    }
}

@Composable
fun BuildDescription(post: Post) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(Color.Black, fontWeight = FontWeight.Bold)) {
            append(post.userName)
        }
        append(" ")
        append(post.description)
    }

    Text(
        text = annotatedString,
        fontSize = 12.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 2,
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
    )
}


@Composable
@Preview
fun PostItemPreview() {
    PostItem(
        post = Post(
            profile = R.drawable.image1,
            userName = "naghi",
            postImageList = listOf(
                R.drawable.image1,
                R.drawable.image3,
            ),
            description = "hjkhjksdfhkj jhhqhf ljkhkqhwe hhkwqehfkhk",
            likedBy = listOf(
                User(profile = R.drawable.image1, userName = "hassan"),
                User(profile = R.drawable.image2, userName = "naghi"),
                User(profile = R.drawable.image3, userName = "gholi"),
                User(profile = R.drawable.image1, userName = "david")
            )
        ),
    )
}