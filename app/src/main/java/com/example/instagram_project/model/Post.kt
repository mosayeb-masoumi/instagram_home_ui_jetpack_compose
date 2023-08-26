package com.example.instagram_project.model

import com.example.instagram_project.R

data class Post(
    val profile: Int,
    val userName: String,
    val postImageList: List<Int>,
    val description: String,
    val likedBy: List<User>
)

object GetPosts {
    val posts = listOf(
        Post(
            profile = R.drawable.image1,
            userName = "mosayeb",
            postImageList = listOf(
                R.drawable.image1,
            ),
            description = "hjkhjksdfhkj jhhqhf ljkhkqhwe hhkwqehfkhk",
            likedBy = listOf(
                User(profile = R.drawable.image1, userName = "hassan"),
            )
        ),

        Post(
            profile = R.drawable.image2,
            userName = "hassan",
            postImageList = listOf(
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
            ),
            description = "hjkhjksdfhkj jhhqhf ljkhkqhwe hhkwqehfkhk",
            likedBy = listOf(
                User(profile = R.drawable.image1, userName = "hassan"),
                User(profile = R.drawable.image2, userName = "naghi"),
            )
        ),

        Post(
            profile = R.drawable.image3,
            userName = "farshad",
            postImageList = listOf(
                R.drawable.image2,
                R.drawable.image3,
            ),
            description = "hjkhjksdfhkj jhhqhf ljkhkqhwe hhkwqehfkhk",
            likedBy = listOf(
                User(profile = R.drawable.image1, userName = "hassan"),
                User(profile = R.drawable.image2, userName = "naghi"),
                User(profile = R.drawable.image3, userName = "gholi"),
                User(profile = R.drawable.image1, userName = "david"),
                User(profile = R.drawable.image2, userName = "saeed"),
            )
        ),

        Post(
            profile = R.drawable.image1,
            userName = "naghiii",
            postImageList = listOf(
                R.drawable.image1,
                R.drawable.image3,
            ),
            description = "hjkhjksdfhkj jhhqhf ljkhkqhwe hhkwqehfkhk" +
                    "hjkhjksdfhkj jhhqhf ljkhkqhwe hhkwqehfkhk hjkhjksdfhkj jhhqhf ljkhkqhwe hhkwqehfkhk" +
                    "hjkhjksdfhkj jhhqhf ljkhkqhwe hhkwqehfkhk",
            likedBy = listOf(
                User(profile = R.drawable.image1, userName = "hassan"),
                User(profile = R.drawable.image2, userName = "naghi"),
                User(profile = R.drawable.image3, userName = "gholi"),
                User(profile = R.drawable.image1, userName = "david"),
                User(profile = R.drawable.image1, userName = "hassan"),
                User(profile = R.drawable.image2, userName = "naghi"),
                User(profile = R.drawable.image3, userName = "gholi"),
                User(profile = R.drawable.image1, userName = "david")
            )
        ),
    )
}


data class User(
    val profile: Int,
    val userName: String,
    val storyCount: Int = 0,
    val stories: List<Int> = listOf()
)