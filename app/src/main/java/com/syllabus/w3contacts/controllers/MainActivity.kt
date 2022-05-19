package com.syllabus.w3contacts.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.models.Contact
import com.syllabus.w3contacts.viewmodels.MainViewModel
import com.syllabus.w3contacts.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val model by viewModels<MainViewModel> { MainViewModelFactory(application) }

    private val contactList by lazy { findViewById<RecyclerView>(R.id.contact_list) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ContactAdapter()
        contactList.adapter = adapter
        model.contacts.observe(this, Observer {
            adapter.contacts = it
            adapter.notifyDataSetChanged()
        })

    }

}