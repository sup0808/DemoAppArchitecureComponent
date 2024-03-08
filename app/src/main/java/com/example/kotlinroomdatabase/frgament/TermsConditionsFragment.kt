package com.example.kotlinroomdatabase.frgament

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.kotlinroomdatabase.R
import com.example.kotlinroomdatabase.databinding.FragmentHomeBinding
import com.example.kotlinroomdatabase.databinding.FragmentTermsconditionBinding


class TermsConditionsFragment : Fragment() {

    lateinit var binding: FragmentTermsconditionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentTermsconditionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       
    }

}