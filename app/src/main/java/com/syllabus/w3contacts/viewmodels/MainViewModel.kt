package com.syllabus.w3contacts.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.syllabus.w3contacts.models.Contact
import com.syllabus.w3contacts.models.MainDataBase
import kotlinx.coroutines.launch

class MainViewModel(private val app:Application) : ViewModel() {

    private val database by lazy { MainDataBase.getInstance(app) }
    val contacts by lazy { database.contacts.getAll() }

    fun insert(contact: Contact) = viewModelScope.launch { database.contacts.insert(contact) }
    fun update(contact: Contact) = viewModelScope.launch { database.contacts.update(contact) }
    fun delete(contact: Contact) = viewModelScope.launch { database.contacts.delete(contact) }
    fun getById(id: Int) = database.contacts.getById(id)

}

class MainViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(app)
    }

}