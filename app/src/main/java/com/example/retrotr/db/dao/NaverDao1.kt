package com.example.retrotr.db.dao

import com.example.retrotr.db.entitiy.NaverMovie1
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NaverDao1 {
    @Query("SELECT*FROM NaverMovie1")
    fun getAllList(): LiveData<List<NaverMovie1>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(naverMovie1: NaverMovie1)

    @Delete
    fun delete(naverMovie1: NaverMovie1)
}

//@Dao
//interface NaverDao1{
//    @Query("SELECT*FROM NaverMovie1")
//   fun getAllList():LiveData<List<NaverMovie1>>
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(naverMovie: NaverMovie1)
//    @Delete
//    fun delete(naverMovie: NaverMovie1)
//
//
//}
