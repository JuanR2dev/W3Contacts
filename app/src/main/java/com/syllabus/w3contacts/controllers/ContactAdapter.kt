package com.syllabus.w3contacts.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.databinding.ContactItemBinding
import com.syllabus.w3contacts.models.Contact
import com.syllabus.w3contacts.models.Gender
import com.syllabus.w3contacts.viewmodels.MainViewModel
import kotlin.coroutines.coroutineContext

class ContactAdapter(val viewmodel: MainViewModel) :
    RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    var contacts = listOf<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ContactItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.contact_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.itemView.setOnClickListener {
            viewmodel.selected.postValue(contacts[position])
        }
        holder.bind(contact)
    }

    override fun getItemCount(): Int = contacts.size

    class ViewHolder(private val binding: ContactItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: Contact) {
            binding.item = contact
        }

    }

}