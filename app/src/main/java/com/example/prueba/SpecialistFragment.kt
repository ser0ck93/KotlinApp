package com.example.prueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.prueba.databinding.FragmentLocationBinding
import com.example.prueba.databinding.FragmentSpecialistBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SpecialistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecialistFragment : Fragment() {

    private var _binding: FragmentSpecialistBinding?= null
    private val binding: FragmentSpecialistBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSpecialistBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}