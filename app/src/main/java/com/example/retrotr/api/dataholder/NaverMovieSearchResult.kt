package com.example.retrotr.api.dataholder

import com.example.retrotr.db.entitiy.NaverMovie1

data class NaverMovieSearchResult(
    val lastBuilder: String,
    val total: Int,
    val start: Int,
    val display: Int,
    val items: List<NaverMovie1>

)

