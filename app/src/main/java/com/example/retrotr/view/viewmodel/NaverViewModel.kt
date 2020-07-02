package com.example.retrotr.view.viewmodel

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.retrotr.db.dao.NaverDao1
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.MutableLiveData
import com.example.retrotr.api.NaverApiClient
import com.example.retrotr.db.entitiy.NaverMovie1
import com.example.retrotr.view.adapter.MovieAdapter1
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
        CoroutineScope(Dispatchers.Main).launch {
            val movies = NaverApiClient.api.seachMovie(query).items
            _seachMovieList.value = movies
        }
    }
}
//class NaverViewModel(private val naverDao1: NaverDao1) : ViewModel() {
//    private val viewModeljob = Job()
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModeljob)
//
//    val myBestMovieList: LiveData<List<NaverMovie1>>
//        get() = naverDao1.getAllList()
//
//
//    fun insert(myBestMovie: NaverMovie1) {
//        uiScope.launch {
//            withContext(Dispatchers.IO) {
//                naverDao1.insert(myBestMovie)
//            }
//        }
//
//    }
//
//    fun delete(myBestMovie: NaverMovie1) {
//        uiScope.launch {
//            withContext(Dispatchers.IO) {
//                naverDao1.delete(myBestMovie)
//            }
//        }
//    }
//
//}