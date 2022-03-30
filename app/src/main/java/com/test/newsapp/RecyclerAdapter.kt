package com.test.newsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.newsapp.databinding.RowRecylerBinding
import com.test.newsapp.model.NewsData


class RecyclerAdapter(val newsData: NewsData) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(val binding: RowRecylerBinding, val newsData: NewsData) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(position: Int) {
            binding.newsData = newsData.articles[position]
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: RowRecylerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_recyler,
            parent,
            false
        )
        return ViewHolder(binding, newsData)
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.row_recyler, parent, false)

//        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return newsData.articles.size
    }
}