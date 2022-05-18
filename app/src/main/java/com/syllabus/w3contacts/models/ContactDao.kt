package com.syllabus.w3contacts.models

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {

    @Insert
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact: Contact)

    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getAll(): LiveData<List<Contact>>

    @Query("SELECT * FROM Contact WHERE id = :id")
    fun getById(id: Int): LiveData<Contact?>

}