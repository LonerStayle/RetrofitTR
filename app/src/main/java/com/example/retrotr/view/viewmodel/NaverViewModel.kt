package com.example.retrotr.view.viewmodel

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.retrotr.db.dao.NaverDao1
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.MutableLiveData
import com.example.retrotr.R
import com.example.retrotr.api.NaverApiClient
import com.example.retrotr.db.entitiy.NaverMovie1
import com.example.retrotr.view.adapter.BestMovieAdapter
import com.example.retrotr.view.adapter.MovieAdapter1
import com.example.retrotr.view.dest.InterestingMovieFragment1
import kotlinx.coroutines.*

class NaverViewModel(private val naverDao1: NaverDao1) : ViewModel() {

    val myBestMovieList: LiveData<List<NaverMovie1>>
        get() = naverDao1.getAllList()


    private val _seachMovieList = MutableLiveData<List<NaverMovie1>>()
    val seachMovieList: LiveData<List<NaverMovie1>>
        get() = _seachMovieList

    /**
     * TODO: 관심분리 원리 when 문 긴거 다 여기다 넣기
     */

     val stats = Transformations.map(myBestMovieList) {
     it.dropLast(1)

        }


    /**
     * FIXME: 굳이 withContext 로 변환해서 돌려서 사용할 필요가 없었음
     */
    fun insert(myBestMovie: NaverMovie1) {
        CoroutineScope(Dispatchers.IO).launch {
            naverDao1.insert(myBestMovie)
        }
    }

    fun delete(myBestMovie: NaverMovie1) {
        CoroutineScope(Dispatchers.IO).launch {
            naverDao1.delete(myBestMovie)
        }
    }

    fun seach(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val movies = NaverApiClient.api.seachMovie(query).items
            _seachMovieList.postValue(movies)
        }
    }



}
