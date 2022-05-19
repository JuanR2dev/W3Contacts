package com.syllabus.w3contacts.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.viewmodels.MainViewModel
import com.syllabus.w3contacts.viewmodels.MainViewModelFactory

class ContactListFragment : Fragment(R.layout.fragment_contact_list) {

    private val model: MainViewModel by activityViewModels { MainViewModelFactory(requireActivity().application) }
    private lateinit var contactList: RecyclerView

    private fun bind(view: View) {
        contactList = view.findViewById(R.id.contact_list)
        val adapter = ContactAdapter()
        contactList.adapter = adapter
        model.contacts.observe(viewLifecycleOwner, Observer {
            adapter.contacts = it
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        bind(view!!)
        return view
    }

}