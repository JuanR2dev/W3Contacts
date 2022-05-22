package com.syllabus.w3contacts.controllers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.syllabus.w3contacts.R
import com.syllabus.w3contacts.databinding.FragmentContactInfoBinding
import com.syllabus.w3contacts.databinding.FragmentContactListBinding
import com.syllabus.w3contacts.models.Gender
import com.syllabus.w3contacts.viewmodels.MainViewModel
import com.syllabus.w3contacts.viewmodels.MainViewModelFactory

class ContactInfoFragment : Fragment() {

    private lateinit var binding: FragmentContactInfoBinding

    private val viewmodel: MainViewModel by activityViewModels {
        MainViewModelFactory(
            requireActivity().application
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contact_info, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewmodel
        viewmodel.selected.observe(viewLifecycleOwner) {
            binding.genderIcon.setImageResource(
                when (it?.gender ?: Gender.None) {
                    Gender.Male -> R.drawable.ic_mars
                    Gender.Female -> R.drawable.ic_venus
                    Gender.None -> R.drawable.ic_genderless
                }
            )
        }
        return binding.root
    }

}