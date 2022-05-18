package com.syllabus.w3contacts.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contact(
    var firstname: String,
    var lastname: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)