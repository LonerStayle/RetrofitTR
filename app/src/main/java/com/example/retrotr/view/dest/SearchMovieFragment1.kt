package com.example.retrotr.view.dest

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.retrotr.R
import com.example.retrotr.api.NaverApiClient
import com.example.retrotr.databinding.FragmentSearchMovieBinding
import com.example.retrotr.db.MovieDataBase1
import com.example.retrotr.db.entitiy.NaverMovie1
import com.example.retrotr.view.adapter.MovieAdapter1
import com.example.retrotr.view.viewmodel.NaverViewModel
import com.example.retrotr.view.viewmodel.NaverViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchMovieFragment1 : Fragment() {

    private val viewModel: NaverViewModel by lazy {
        val movieDataBase1 = MovieDataBase1.getInstance(requireContext())
        val factory = NaverViewModelFactory(movieDataBase1.naverDao)
        ViewModelProvider(this, factory).get(NaverViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentSearchMovieBinding>(
        inflater,
        R.layout.fragment_search_movie,
        container,
        false
    ).run {
        vm = viewModel
        val movieAdapter1 = MovieAdapter1(context = requireContext(), viewModel = viewModel)

        viewModel.seachMovieList.observe(viewLifecycleOwner, Observer {

                movieAdapter1.movieList = it
                recyclerView.adapter = movieAdapter1
                movieAdapter1.notifyDataSetChanged()
            })


        root
    }

}
