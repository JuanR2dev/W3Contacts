package com.syllabus.w3contacts

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.syllabus.w3contacts.models.Contact
import com.syllabus.w3contacts.models.MainDataBase
import kotlinx.coroutines.*
import org.junit.Test
import org.junit.runner.RunWith
import java.io.Console

@RunWith(AndroidJUnit4::class)
class RoomTest {

    private val context by lazy { InstrumentationRegistry.getInstrumentation().targetContext }
    private val scope by lazy { CoroutineScope(SupervisorJob()) }

    @Test
    fun singleIntegrityTest() {
        runBlocking {
            val database = MainDataBase.getInstance(context)
            runBlocking {
                database.contacts.insert(
                    Contact(
                        firstname = "Juan",
                        lastname = "Chavez"
                    )
                )
            }
            var user = database.contacts.getById(1)
            assert(user.value?.firstname == "Juan")
            user.value?.firstname = "Jesus"
            runBlocking { database.contacts.update(user.value!!) }
            user = database.contacts.getById(1)
            assert(user.value?.firstname == "Jesus")
        }
    }

}