package com.example.instagram_project.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram_project.R


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostCarousel(postImageList: List<Int>) {

    // material3
    val pagerState = rememberPagerState(pageCount = { postImageList.size })

//    val pagerState = rememberPagerState(pageCount = postImageList.size)

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {


        Column() {
            BuildHorizontalPager(pagerState, postImageList)
            BuildIndicator(pagerState, postImageList)
        }


        if (postImageList.size > 1)
            Row(
                modifier = Modifier
                    .padding(all = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = Color.Black.copy(alpha = 0.5f))
                    .padding(horizontal = 5.dp, vertical = 2.dp)
                    .align(Alignment.TopEnd),

                ) {
                Text(
                    text = "${pagerState.currentPage + 1}/${postImageList.size}",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }

    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildIndicator(pagerState: PagerState, postImageList: List<Int>) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 5.dp),
    ) {

        Row(modifier = Modifier.align(alignment = Alignment.CenterStart)) {
            Icon(
                imageVector = Icons.Default.Favorite,
                tint = Color.Red, contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Default.Email, contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(
                imageVector = Icons.Default.Send, contentDescription = "",
                tint = Color.Blue,
                modifier = Modifier.size(24.dp)
            )
        }


        //indicator
        if (postImageList.size > 1)
            Row(
                Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(postImageList.size) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(7.dp)

                    )
                }
            }




        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(alignment = Alignment.CenterEnd),
            imageVector = Icons.Default.Share, contentDescription = "",
        )

    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildHorizontalPager(pagerState: PagerState, postImageList: List<Int>) {

    // material3
    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth()) { currentPage ->
        Image(
            painter = painterResource(id = postImageList[currentPage]),
            contentDescription = "post",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
        )
    }


}


@Composable
@Preview
fun PostCarouselPreview() {
    PostCarousel(
        postImageList = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
        )
    )
}