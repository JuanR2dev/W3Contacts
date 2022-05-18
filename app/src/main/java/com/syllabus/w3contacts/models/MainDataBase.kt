package com.syllabus.w3contacts.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class MainDataBase : RoomDatabase() {

    abstract val contacts: ContactDao

    companion object {

        @Volatile
        private var INSTANCE : MainDataBase? = null

        fun getInstance(context:Context):MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, MainDataBase::class.java, "main_database").build()
                INSTANCE = instance
                return instance
            }
        }

    }

}