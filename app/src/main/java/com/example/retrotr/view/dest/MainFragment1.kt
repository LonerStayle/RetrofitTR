package com.example.retrotr.view.dest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrotr.R
import com.example.retrotr.databinding.FragmentMainBinding
import com.example.retrotr.db.MovieDataBase1
import com.example.retrotr.db.entitiy.NaverMovie1
import com.example.retrotr.view.adapter.TabPageAdapter1
import com.example.retrotr.view.viewmodel.NaverViewModel
import com.example.retrotr.view.viewmodel.NaverViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment1 :Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = DataBindingUtil.inflate<FragmentMainBinding>(inflater,R.layout.fragment_main,container,false).run {

        viewPager.adapter = TabPageAdapter1(this@MainFragment1)
        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            when(position) {
                0 -> tab.text = "A"
                1 -> tab.text = "B"
            }
        }.attach()

//        viewPager.adapter = TabPageAdapter1(this@MainFragment1)
//
//         TabLayoutMediator(tabLayout,viewPager){tab, position ->
//            when(position) {
//                0 -> tab.text ="A"
//                1 -> tab.text ="B"
//            }
//
//        }.attach()
//
//
        root
    }
}

