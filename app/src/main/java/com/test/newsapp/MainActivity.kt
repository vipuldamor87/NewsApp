package com.test.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.test.newsapp.ViewModel.NewsViewModel
import com.test.newsapp.databinding.ActivityMainBinding
import com.test.newsapp.network.ApiService

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel
    private val apiService = ApiService.getInstance()


    val TabsArray = arrayOf(
        "Apple",
        "Tesla",
        "Business",
        "India"
    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = TabsArray[position]
        }.attach()

//        viewModel = ViewModelProvider(this, MyViewModelFactory(Repository(apiService))).get(NewsViewModel::class.java)
//
//        viewModel.newsList.observe(this, Observer {
//            Log.e("asd",it.toString())
//        })
//        viewModel.getNewsTesla()


    }
}