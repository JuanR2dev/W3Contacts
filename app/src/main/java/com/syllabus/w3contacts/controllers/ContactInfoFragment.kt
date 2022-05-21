package com.syllabus.w3contacts.controllers

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.createBitmap
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.databinding.FragmentContactInfoBinding
import com.syllabus.w3contacts.databinding.FragmentContactListBinding
import com.syllabus.w3contacts.viewmodels.MainViewModel
import com.syllabus.w3contacts.viewmodels.MainViewModelFactory

class ContactInfoFragment : Fragment() {

    private lateinit var binding: FragmentContactInfoBinding

    private val viewmodel: MainViewModel by activityViewModels {
        MainViewModelFactory(
            requireActivity().application
        )
    }

    // TODO: Remove experiment
    private val pickPhoto = registerForActivityResult(ActivityResultContracts.GetContent()) {
        Toast.makeText(context, it.toString(), Toast.LENGTH_LONG).show()
        val string = it.toString()
        val uri = Uri.parse(string)
        binding.imagePreview.setImageURI(uri)
    }

    fun bind() {
        // TODO: Remove experiment
        binding.pickImageButton.setOnClickListener {
            pickPhoto.launch("image/*")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_info, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewmodel
        bind()
        return binding.root
    }

}