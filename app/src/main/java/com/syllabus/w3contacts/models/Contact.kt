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

    companion object {
        const val MEN_URL = "https://randomuser.me/api/portraits/men"
        const val WOMEN_URL = "https://randomuser.me/api/portraits/women"
        const val LEGO_URL = "https://randomuser.me/api/portraits/lego"
    }

    val completeName get() = "$firstname $lastname"
    val formatEmail get() = email ?: "..."
    val formatPhoneNumber get() = phoneNumber ?: "..."
    val avatarURL
        get() = when (gender) {
            Gender.Male -> "$MEN_URL/$id.jpg"
            Gender.Female -> "$WOMEN_URL/$id.jpg"
            Gender.None -> "$LEGO_URL/$id.jpg"
        }

    fun getFormatGender(context: Context): String {
        return when (gender) {
            Gender.Male -> context.getString(R.string.gender_male)
            Gender.Female -> context.getString(R.string.gender_female)
            else -> ""
        }
    }

    fun getFormatInfoSummary(context: Context): String {
        return "$age ${context.getString(R.string.contact_years)} ${getFormatGender(context)}"
    }

}