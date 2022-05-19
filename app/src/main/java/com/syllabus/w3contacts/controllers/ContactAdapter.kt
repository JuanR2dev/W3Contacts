package com.syllabus.w3contacts.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.models.Contact

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    var contacts = listOf<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int = contacts.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtText by lazy { view.findViewById<TextView>(R.id.txt_text) }

        fun bind(contact: Contact) {
            txtText.text = contact.firstname
        }

    }

}