package com.syllabus.w3contacts.repositories

import com.syllabus.w3contacts.models.Contact
import com.syllabus.w3contacts.models.MainDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class ContactRepository(private val database: MainDataBase) {

    suspend fun insert(contact: Contact) = database.contacts.insert(contact)
    suspend fun update(contact: Contact) = database.contacts.update(contact)
    suspend fun delete(contact: Contact) = database.contacts.delete(contact)

    fun getAll() = database.contacts.getAll()
    fun getById(id: Int) = database.contacts.getById(id)

}