package com.test.newsapp.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.newsapp.RecyclerAdapter
import com.test.newsapp.ViewModel.MyViewModelFactory
import com.test.newsapp.ViewModel.NewsViewModel
import com.test.newsapp.databinding.FragmentTeslaBinding
import com.test.newsapp.network.ApiService
import com.test.newsapp.network.Repository

class BusinessFragment: Fragment() {

    private lateinit var binding: FragmentTeslaBinding
    private  lateinit var viewModel : NewsViewModel
    private val apiService = ApiService.getInstance()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTeslaBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.recyclerView.layoutManager = LinearLayoutManager(context)
//        binding.recyclerView.adapter = RecyclerAdapter()

        viewModel = ViewModelProvider(this, MyViewModelFactory(Repository(apiService))).get(
            NewsViewModel::class.java)

        viewModel.newsList.observe(viewLifecycleOwner, Observer {
            Log.e("asd",it.toString())
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
            binding.recyclerView.adapter = RecyclerAdapter(it)
        })
        viewModel.getBusinessData()
    }

}