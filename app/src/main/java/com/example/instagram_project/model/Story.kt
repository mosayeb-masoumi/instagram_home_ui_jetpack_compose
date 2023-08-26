package com.example.instagram_project.model

import com.example.instagram_project.R

data class Story(
    val userName: String,
    val profile: String,
    val image: Int
)

object StoryList {
    val list = listOf(
        Story("mosayeb", "Mosayebi", R.drawable.image1),
        Story("hassan", "Hasani", R.drawable.image2),
        Story("Nabi", "Rezai", R.drawable.image3),
        Story("Milad", "Noory", R.drawable.image1),
        Story("Reza", "Taghi", R.drawable.image2),
        Story("Davis", "Jason", R.drawable.image3),
        Story("mosayeb", "Mosayebi", R.drawable.image1),
        Story("hassan", "Hasani", R.drawable.image2),
        Story("Nabi", "Rezai", R.drawable.image3),
        Story("Milad", "Noory", R.drawable.image1),
        Story("Ali", "Mehrdadi", R.drawable.image2),
        Story("Hossein", "naghivand", R.drawable.image3),
    )
}


