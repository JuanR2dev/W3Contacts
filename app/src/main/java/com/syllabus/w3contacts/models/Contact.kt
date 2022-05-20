package com.syllabus.w3contacts.models

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.syllabus.w3contacts.R

@Entity
class Contact(
    var firstname: String,
    var lastname: String,
    var age: Int,
    var gender: Gender = Gender.None,
    var email: String? = null,
    var phoneNumber: String? = null,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) {

    val completeName get() = "$firstname $lastname"

    fun getFormatGender(context: Context): String {
        return when (gender) {
            Gender.Male -> context.getString(R.string.gender_male)
            Gender.Female -> context.getString(R.string.gender_female)
            else -> context.getString(R.string.gender_none)
        }
    }

    fun getFormatInfoSummary(context: Context): String {
        return "$age ${context.getString(R.string.contact_years)} ${getFormatGender(context)}"
    }

}