package com.example.retrotr.view.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.retrotr.view.dest.InterestingMovieFragment1
import com.example.retrotr.view.dest.SearchMovieFragment1

class TabPageAdapter1(fragment: Fragment):FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
    when (position) {

        INDEX_PAGE_SEARCH_MOVIE -> SearchMovieFragment1()
        else -> InterestingMovieFragment1()
    }

    companion object{
        private const val INDEX_PAGE_INTERE_MOVIE = 0
        private const val INDEX_PAGE_SEARCH_MOVIE = 1

    }
}
//class TabPageAdapter1(fragment: Fragment):FragmentStateAdapter(fragment) {
//    override fun getItemCount(): Int = 2
//
//    override fun createFragment(position: Int): Fragment =
//        when (position) {
//            0 -> InterestingMovieFragment1()
//            1 -> SearchMovieFragment1()
//            else -> InterestingMovieFragment1()
//
//        }
//}

