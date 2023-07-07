package com.jayeshsapplication.app.modules.feeds.ui

data class PixabayApiResponse(
    val total: Int,
    val totalHits: Int,
    val hits: List<ImageResponse>
)
