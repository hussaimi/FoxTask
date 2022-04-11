package com.example.foxTask.data

enum class Component {
    BIG_TOP,
    RIVER,
    AD,
    HOUSE_AD,
    SLIDE_SHOW
}

data class FeedItem(val component: Component, val headline: String, val imageUrl: String?)