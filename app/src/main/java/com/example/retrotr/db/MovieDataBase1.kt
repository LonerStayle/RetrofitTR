package com.example.retrotr.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrotr.db.dao.NaverDao1
import com.example.retrotr.db.entitiy.NaverMovie1

@Database(entities = [NaverMovie1::class],version = 1 , exportSchema = false )
abstract class MovieDataBase1 :RoomDatabase(){
    abstract val naverDao:NaverDao1

    companion object {
        @Volatile
        private var INSTANCE: MovieDataBase1? = null

        fun getInstance(context: Context): MovieDataBase1 = synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(
                context,
                MovieDataBase1::class.java,
                "naver_database"
            ).fallbackToDestructiveMigration().build().also {
                INSTANCE = it
            }
        }
    }
}

//@Database(entities = [NaverMovie1::class],version = 1,exportSchema = false)
//abstract class MovieDataBase1 :RoomDatabase(){
//    abstract val naverDao1:NaverDao1
//
//    companion object{
//        @Volatile
//        private var INSTACNE:MovieDataBase1?=null
//
//        fun getInstace(context: Context):MovieDataBase1= synchronized(this){
//            INSTACNE?:Room.databaseBuilder(
//                context,
//        MovieDataBase1::class.java,
//                "naver_database"
//            ).fallbackToDestructiveMigration().build().also {
//                INSTACNE = it
//            }
//        }
//    }
//
//}
//
