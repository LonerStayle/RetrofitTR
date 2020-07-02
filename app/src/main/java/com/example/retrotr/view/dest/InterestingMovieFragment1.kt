package com.example.retrotr.view.dest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.retrotr.R
import com.example.retrotr.databinding.FragmentInterestingMovieBinding
import com.example.retrotr.view.viewmodel.NaverViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrotr.db.MovieDataBase1
import com.example.retrotr.db.entitiy.NaverMovie1
import com.example.retrotr.view.adapter.BestMovieAdapter
import com.example.retrotr.view.viewmodel.NaverViewModelFactory


class InterestingMovieFragment1 : Fragment() {

    private val viewModel: NaverViewModel by lazy {
        val movieDataBase = MovieDataBase1.getInstance(requireContext())
        val factory = NaverViewModelFactory(movieDataBase.naverDao)
        ViewModelProvider(this, factory).get(
            NaverViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentInterestingMovieBinding>(
        inflater,
        R.layout.fragment_interesting_movie,
        container,
        false
    ).run {

        val bestMovieAdapter = BestMovieAdapter(context = requireContext(), viewModel = viewModel)
        recyclerViewMyBestMovieList.adapter = bestMovieAdapter

        viewModel.myBestMovieList.observe(viewLifecycleOwner, Observer {
                (recyclerViewMyBestMovieList.adapter as BestMovieAdapter).run {
                    /**
                     * TODO: 관심분리 원리, VIEWMODEL 트랜스폼에 처박을것
                     */
                    when {
                        it.isNotEmpty() && movieList.contains(NaverMovie1(it.last().title, it.last().image))
                                && movieList.size == it.size ->
                            Toast.makeText(context, R.string.toast_doubleCheckedBestMovie, Toast.LENGTH_SHORT
                            ).show()

                        it.isNotEmpty() && !movieList.contains(NaverMovie1(it.last().title, it.last().image))
                        -> { movieList = it
                            Toast.makeText(context, R.string.toast_bestMovieAddComplete, Toast.LENGTH_SHORT).show() }

                        else ->
                            if (movieList.isNotEmpty()) {
                                movieList = it
                                Toast.makeText(context, R.string.toast_bestMovieRemove, Toast.LENGTH_SHORT
                                ).show()
                            }
                    }
                    notifyDataSetChanged()
                }
            })


        root
    }

}

//        val bestMovieAdapter = BestMovieAdapter(context = requireContext(), viewModel = viewModel)
//        recyclerViewMyBestMovieList.adapter = bestMovieAdapter
//        viewModel.apply {
//            myBestMovieList.observe(viewLifecycleOwner, Observer {
//                (recyclerViewMyBestMovieList.adapter as BestMovieAdapter).run {
//
//                    when {
//                        it.isNotEmpty() && movieList.contains(NaverMovie1(it.last().title, it.last().image))
//                                && movieList.size == it.size ->
//                            Toast.makeText(context, R.string.toast_doubleCheckedBestMovie, Toast.LENGTH_SHORT
//                            ).show()
//
//                        it.isNotEmpty() && !movieList.contains(NaverMovie1(it.last().title, it.last().image)) -> {
//                            movieList = it
//                            Toast.makeText(context, R.string.toast_bestMovieAddComplete, Toast.LENGTH_SHORT).show()
//                        }
//                        else ->
//                            if (movieList.isNotEmpty()) {
//                                movieList = it
//                                Toast.makeText(context, R.string.toast_bestMovieRemove, Toast.LENGTH_SHORT).show()
//                            }
//                    }
//                    notifyDataSetChanged()
//                }
//            })
//        }
//
