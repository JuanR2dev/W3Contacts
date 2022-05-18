package com.syllabus.w3contacts.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.syllabus.w3contacts.models.MainDataBase

class MainViewModel(private val app:Application) : ViewModel() {

    private val database by lazy { MainDataBase.getInstance(app) }
    val contacts by lazy { database.contacts.getAll() }

}

class MainViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(app)
    }

}