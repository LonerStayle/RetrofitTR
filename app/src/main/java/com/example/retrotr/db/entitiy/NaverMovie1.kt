package com.example.retrotr.db.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * FIXME: id 살리기, 딱 하나만의 프라이 머리가 되아야만 함
 */
@Entity
data class NaverMovie1(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String,
    val link:String,
    val image: String,
    val subtitle:String,
    val pubDate:String,
    val actor:String,
    val userRating:String
)


//@Entity
//data class NaverMovie1(
////    @PrimaryKey(autoGenerate = true)
////    val id: Long = 0L,
//    @PrimaryKey
//    val title: String,
////    val link: String,
//    val image: String
////    val subtitle: String,
////    val pubDate: String,
////    val director: String,
////    val actor: String,
////    val userRating: String
//)
