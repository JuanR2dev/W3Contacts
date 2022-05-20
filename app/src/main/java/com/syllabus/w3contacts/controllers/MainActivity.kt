package com.syllabus.w3contacts.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.databinding.ActivityMainBinding
import com.syllabus.w3contacts.viewmodels.MainViewModel
import com.syllabus.w3contacts.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewmodel: MainViewModel by viewModels { MainViewModelFactory(application) }
    private val contactListContainer: FragmentContainerView by lazy { findViewById(R.id.contact_list_container) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel

        supportFragmentManager.commit {
            replace<ContactListFragment>(R.id.contact_list_container)
            setReorderingAllowed(true)
            addToBackStack("contact_list")
        }

    }

}