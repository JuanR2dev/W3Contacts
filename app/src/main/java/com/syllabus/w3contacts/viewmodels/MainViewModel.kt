package com.syllabus.w3contacts.viewmodels

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.syllabus.w3contacts.models.Contact
import com.syllabus.w3contacts.models.Gender
import com.syllabus.w3contacts.models.MainDataBase
import com.syllabus.w3contacts.repositories.ContactRepository
import kotlinx.coroutines.launch

class MainViewModel(private val app: Application) : ViewModel() {

    private val database by lazy { MainDataBase.getInstance(app) }
    private val contactRepo by lazy { ContactRepository(database) }

    val contacts by lazy { contactRepo.getAll() }
    var selected: MutableLiveData<Contact?> = MutableLiveData()

    /*
    init {
        viewModelScope.launch {
            contactRepo.insert(
                Contact(
                    firstname = "Juan Jesus",
                    lastname = "Chavez Villa",
                    age = 22,
                    gender = Gender.Male,
                    email = "juanjesus.chavez@r2devpros.com",
                    phoneNumber = "8611175346"
                )
            )
        }
    }
    */

}

class MainViewModelFactory(private val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Application::class.java).newInstance(app)
    }

}