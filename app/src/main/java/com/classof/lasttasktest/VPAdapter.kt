package com.classof.lasttasktest

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class VPAdapter (fragment : FragmentActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> BlankFragment1()
            1 -> BlankFragment2()
            2 -> BlankFragment3()
            else -> BlankFragment1()
        }
    }
}