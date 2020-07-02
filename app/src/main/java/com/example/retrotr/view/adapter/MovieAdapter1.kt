package com.example.retrotr.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrotr.R
import com.example.retrotr.databinding.ViewholderMovieBinding
import com.example.retrotr.db.entitiy.NaverMovie1
import com.example.retrotr.view.dialog.Dialog
import com.example.retrotr.view.viewmodel.NaverViewModel

class MovieAdapter1(
    var movieList: List<NaverMovie1> = listOf(),
    val context: Context,
    var viewModel: NaverViewModel
) : RecyclerView.Adapter<MovieAdapter1.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<ViewholderMovieBinding>(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_movie, parent, false)
        )

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding?.apply {
            val movie = movieList[position]
            url = movie.image
            title = movie.title
        }

        holder.itemView.setOnClickListener {
            Dialog.show(context,R.string.dialog_saveLikeMoiveTitle,R.string.dialog_saveLikeMoiveText
            ,R.string.dialog_saveLikeMoivePositiveText,{viewModel.insert(movieList[position])},R.string.dialog_saveLikeMoiveNegativeText,
                {return@show})
        }
    }
}


//class MovieAdapter1(
//    var movieList: List<NaverMovie1> = listOf(),
//    var context: Context,
//    var viewModel: NaverViewModel
//) : RecyclerView.Adapter<MovieAdapter1.ViewHolder>() {
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
//        ViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_movie, parent, false)
//        )
//
//    override fun getItemCount(): Int = movieList.size
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.binding?.apply {
//            val movie = movieList[position]
//            url = movie.image
//            title = movie.title
//        }
//        holder.itemView.setOnClickListener {
//
//            Dialog.show(
//                context,
//                R.string.dialog_saveLikeMoiveTitle,
//                R.string.dialog_saveLikeMoiveText,
//                R.string.dialog_saveLikeMoivePositiveText, {
//
//                    viewModel.insert(movieList[position])
//
//                },
//                R.string.dialog_saveLikeMoiveNegativeText,
//                { return@show })
//        }
//    }
//
//    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val binding = DataBindingUtil.bind<ViewholderMovieBinding>(view)
//
//    }
//}
