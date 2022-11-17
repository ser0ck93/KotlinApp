package com.example.prueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prueba.databinding.FragmentLoginBinding
import com.example.prueba.databinding.FragmentSignUpBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SignUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUpFragment : Fragment() {

private var _binding: FragmentSignUpBinding?=null
    private val binding: FragmentSignUpBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.signupFragmentLoginLabelL2.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment2_to_loginFragment)
        }
    }
}