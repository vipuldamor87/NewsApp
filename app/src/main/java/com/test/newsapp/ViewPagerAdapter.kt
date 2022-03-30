package com.test.newsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.test.newsapp.Fragments.AppleFragment
import com.test.newsapp.Fragments.BusinessFragment
import com.test.newsapp.Fragments.IndiaFragment
import com.test.newsapp.Fragments.TeslaFragment

public class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return AppleFragment()
            1 -> return TeslaFragment()
            2 -> return BusinessFragment()
            3 -> return IndiaFragment()
        }
        return TeslaFragment()
    }
}