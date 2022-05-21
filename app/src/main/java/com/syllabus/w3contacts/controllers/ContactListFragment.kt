package com.syllabus.w3contacts.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.databinding.ActivityMainBinding
import com.syllabus.w3contacts.databinding.FragmentContactListBinding
import com.syllabus.w3contacts.viewmodels.MainViewModel
import com.syllabus.w3contacts.viewmodels.MainViewModelFactory

class ContactListFragment : Fragment() {

    private val viewmodel: MainViewModel by activityViewModels {
        MainViewModelFactory(
            requireActivity().application
        )
    }
    private lateinit var binding: FragmentContactListBinding

    private fun bind() {
        val adapter = ContactAdapter(viewmodel)
        binding.contactList.adapter = adapter
        viewmodel.contacts.observe(viewLifecycleOwner, Observer {
            adapter.contacts = it
            adapter.notifyDataSetChanged()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_list, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewmodel
        bind()
        return binding.root
    }

}