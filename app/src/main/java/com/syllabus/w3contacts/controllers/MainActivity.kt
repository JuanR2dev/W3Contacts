package com.syllabus.w3contacts.controllers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.viewmodels.MainViewModel
import com.syllabus.w3contacts.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private val model by viewModels<MainViewModel> { MainViewModelFactory(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model.contacts.observe(this, Observer {
            findViewById<TextView>(R.id.txt_text).text = it.firstOrNull()?.firstname
        })
    }

}