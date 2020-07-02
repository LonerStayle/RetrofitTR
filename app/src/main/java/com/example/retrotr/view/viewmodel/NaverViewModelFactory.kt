package com.example.retrotr.view.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrotr.db.dao.NaverDao1
import java.lang.IllegalArgumentException

class NaverViewModelFactory (private val naverDao1: NaverDao1):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NaverViewModel::class.java)) {
            return NaverViewModel(naverDao1) as T
        }
        throw IllegalArgumentException("UnKnown NaverViewModel Class")
    }
}