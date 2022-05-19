package com.syllabus.w3contacts.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.models.Contact
import com.syllabus.w3contacts.viewmodels.MainViewModel
import com.syllabus.w3contacts.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val model: MainViewModel by viewModels { MainViewModelFactory(application) }
    private val contactListContainer: FragmentContainerView by lazy { findViewById(R.id.contact_list_container) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.commit {
            replace<ContactListFragment>(R.id.contact_list_container)
            setReorderingAllowed(true)
            addToBackStack("contact_list")
        }

    }

}