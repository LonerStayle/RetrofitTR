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

    companion object {
        const val NOT_WORKING_DELETE_MESSAGE = 101010
        const val WORKING_DELETE_MESSAGE = 0
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
        recyclerViewMyBestMovieList.adapter = bestMovieAdapter.apply {

        }


        var doubleCheckedInDeleteMessage = WORKING_DELETE_MESSAGE


        viewModel.myBestMovieList.observe(viewLifecycleOwner, Observer { updated ->
            (recyclerViewMyBestMovieList.adapter as BestMovieAdapter).run {
                /**
                 * TODO: 관심분리 원리, VIEWMODEL 트랜스폼에 처박을것
                 */

                when {
                    movieList.any {
                        it.image == updated.last().image && it.title == updated.last().title
                    } && updated.size > movieList.size -> {

                        toast(R.string.toast_doubleCheckedBestMovie)

                        viewModel.delete(updated.last())
                        doubleCheckedInDeleteMessage = NOT_WORKING_DELETE_MESSAGE
                    }

                    !movieList.any {
                        it.image == updated.last().image && it.title == updated.last().title
                    } && updated.size > movieList.size -> {

                        toast(R.string.toast_bestMovieAddComplete)

                    }
                    updated.size < movieList.size &&
                            doubleCheckedInDeleteMessage == WORKING_DELETE_MESSAGE -> {
                        toast(R.string.toast_bestMovieRemove)

                    }
                    doubleCheckedInDeleteMessage == NOT_WORKING_DELETE_MESSAGE -> {
                        doubleCheckedInDeleteMessage = WORKING_DELETE_MESSAGE
                    }
                }

                movieList = updated
                notifyDataSetChanged()
            }
        })



        root
    }

    private fun toast(message: Int) {
        Toast.makeText(
            context, message, Toast.LENGTH_SHORT
        ).show()
    }
}


