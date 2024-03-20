package com.example.kotlinroomdatabase.frgament.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kotlinroomdatabase.R
import com.example.kotlinroomdatabase.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

     val args: LoginFragmentArgs by navArgs()

    lateinit var  binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container,false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.edUserName.setText(args.username)


        binding.button.setOnClickListener{
            val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(
                binding.edUserName.text.toString(),
                binding.password.text.toString())
                findNavController().navigate(action)
         //   findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

    }

}